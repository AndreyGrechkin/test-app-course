package com.defey.testcourse.flow.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.defey.testcourse.di.FlowScope
import com.defey.testcourse.di.ViewModelKey
import com.defey.testcourse.favorite_screen.ui.FavoriteScreenViewModel
import com.defey.testcourse.flows.AppViewModelFactory
import com.defey.testcourse.flows.ViewModelProviders
import com.defey.testcourse.main_screen.ui.MainScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface CoursesFlowModule {

    companion object {
        @FlowScope
        @Provides
        fun provideViewModelFactory(
            providers: ViewModelProviders,
        ): ViewModelProvider.Factory = AppViewModelFactory(providers)
    }

    @Binds
    @IntoMap
    @ViewModelKey(MainScreenViewModel::class)
    fun bindMainScreenViewModel(vm: MainScreenViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteScreenViewModel::class)
    fun bindFavoriteScreenViewModel(vm: FavoriteScreenViewModel): ViewModel
}