package com.defey.testcourse.flow

import com.defey.testcourse.di.FlowNavigationModule
import com.defey.testcourse.di.FlowScope
import com.defey.testcourse.login.di.LoginDependencies
import dagger.Component

@FlowScope
@Component(
    dependencies = [AuthFlowDependencies::class],
    modules = [
        AuthFlowModule::class,
        AuthFlowComponentDependenciesModule::class,
        FlowNavigationModule::class,
    ]
)
interface AuthFlowComponent : LoginDependencies {

    @Component.Factory
    interface Factory {
        fun create(dependencies: AuthFlowDependencies): AuthFlowComponent
    }

    fun inject(fragment: AuthFlowFragment)
}