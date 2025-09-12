package com.defey.testcourse.di

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

open class ComponentHolder<out T : Any, in A>(private val creator: (A) -> T) : ViewModel() {

    @Volatile
    private var component: T? = null

    fun getDaggerComponent(arg: A): T = component ?: creator(arg).also {
        synchronized(this) { component = it }
    }

    fun clear() {
        synchronized(this) { component = null }
    }

    override fun onCleared() {
        clear()
    }
}

inline fun <reified CH : ComponentHolder<*, AppCompatActivity>>
        AppCompatActivity.componentHolder() = lazy {
    ViewModelProvider(this).get(CH::class.java)
}

inline fun <reified CH : ComponentHolder<*, Fragment>>
        Fragment.componentHolder() = lazy {
    ViewModelProvider(this).get(CH::class.java)
}