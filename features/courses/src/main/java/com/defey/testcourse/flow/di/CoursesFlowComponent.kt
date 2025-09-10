package com.defey.testcourse.flow.di

import com.defey.testcourse.di.FlowNavigationModule
import com.defey.testcourse.di.FlowScope
import com.defey.testcourse.favorite_screen.di.FavoriteScreenDependencies
import com.defey.testcourse.flow.ui.CoursesFlowFragment
import com.defey.testcourse.main_screen.di.MainScreenDependencies
import dagger.Component

@FlowScope
@Component(
    dependencies = [CoursesFlowDependencies::class],
    modules = [
        CoursesFlowModule::class,
        CoursesFlowComponentDependenciesModule::class,
        FlowNavigationModule::class
    ]
)
interface CoursesFlowComponent: MainScreenDependencies, FavoriteScreenDependencies  {

    @Component.Factory
    interface Factory {
        fun create(dependencies: CoursesFlowDependencies): CoursesFlowComponent
    }

    fun inject(fragment: CoursesFlowFragment)
}