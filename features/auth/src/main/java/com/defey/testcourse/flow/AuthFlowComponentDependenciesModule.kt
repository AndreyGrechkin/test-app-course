package com.defey.testcourse.flow

import com.defey.testcourse.di.ComponentDependencies
import com.defey.testcourse.di.ComponentDependenciesKey
import com.defey.testcourse.login.di.LoginDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface AuthFlowComponentDependenciesModule {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(LoginDependencies::class)
    fun bindLoginDependencies(component: AuthFlowComponent): ComponentDependencies
}