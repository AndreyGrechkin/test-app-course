package com.defey.testcourse.login.di

import com.defey.testcourse.login.ui.LoginFragment
import dagger.Component

@Component(
    dependencies = [LoginDependencies::class],
    modules = []
)
interface LoginComponent {

    @Component.Factory
    interface Factory {
        fun create(dependencies: LoginDependencies): LoginComponent
    }

    fun inject(fragment: LoginFragment)
}