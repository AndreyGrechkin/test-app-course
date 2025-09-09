package com.defey.testcourse.di

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import dagger.MapKey
import kotlin.reflect.KClass

interface ComponentDependencies

typealias ComponentDependenciesMap = Map<Class<out ComponentDependencies>, @JvmSuppressWildcards ComponentDependencies>

interface HasComponentDependencies {
    val dependencies: ComponentDependenciesMap
}

fun Activity.findComponentDependenciesMap(): ComponentDependenciesMap {
    val dependenciesProvider = when (application) {
        is HasComponentDependencies -> application as HasComponentDependencies
        else -> throw IllegalStateException("Can not find suitable dagger dependencies provider for $this")
    }
    return dependenciesProvider.dependencies
}

inline fun <reified D : ComponentDependencies> Activity.findDependencies(): D {
    val dependencies = findComponentDependenciesMap()[D::class.java]
    return dependencies as? D ?: throw IllegalStateException(
        "No Dependencies ${D::class.java} found. Available: ${findComponentDependenciesMap().keys}"
    )
}

inline fun <reified D : ComponentDependencies> Fragment.findDependencies(): D {
    return findDependenciesByClass(D::class.java)
}

@Suppress("UNCHECKED_CAST")
fun <D : ComponentDependencies> Fragment.findDependenciesByClass(clazz: Class<D>): D {
    return parents.firstNotNullOfOrNull {
        it.dependencies[clazz]
    } as D? ?: throw IllegalStateException("No Dependencies $clazz in ${allParents.joinToString()}")
}


private val Fragment.parents: Iterable<HasComponentDependencies>
    get() = allParents.mapNotNull { it as? HasComponentDependencies }

private val Fragment.allParents: Iterable<Any>
    get() = object : Iterable<Any> {
        override fun iterator() = object : Iterator<Any> {
            private var currentParentFragment: Fragment? = parentFragment
            private var parentActivity: Activity? = activity
            private var parentApplication: Application? = parentActivity?.application

            override fun hasNext() =
                currentParentFragment != null || parentActivity != null || parentApplication != null

            override fun next(): Any {
                currentParentFragment?.let { parent ->
                    currentParentFragment = parent.parentFragment
                    return parent
                }

                parentActivity?.let { parent ->
                    parentActivity = null
                    return parent
                }

                parentApplication?.let { parent ->
                    parentApplication = null
                    return parent
                }

                throw NoSuchElementException()
            }
        }
    }

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class ComponentDependenciesKey(val value: KClass<out ComponentDependencies>)