package com.defey.testcourse.flow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.defey.testcourse.di.FlowScope
import com.defey.testcourse.di.ViewModelKey
import com.defey.testcourse.flows.AppViewModelFactory
import com.defey.testcourse.flows.ViewModelProviders
import com.defey.testcourse.login.ui.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface AuthFlowModule {
    companion object {
        @FlowScope
        @Provides
        fun provideViewModelFactory(
            providers: ViewModelProviders,
        ): ViewModelProvider.Factory = AppViewModelFactory(providers)
    }

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun bindLoginViewModel(vm: LoginViewModel): ViewModel
}