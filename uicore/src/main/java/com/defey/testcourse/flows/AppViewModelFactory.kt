package com.defey.testcourse.flows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Provider

typealias ViewModelProviders = Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>

class AppViewModelFactory(
    private val providers: ViewModelProviders,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        requireNotNull(getProvider(modelClass).get()) {
            "Provider for $modelClass returned null"
        }

    @Suppress("UNCHECKED_CAST")
    private fun <T : ViewModel> getProvider(modelClass: Class<T>): Provider<T> =
        try {
            requireNotNull(providers[modelClass] as Provider<T>) {
                "No ViewModel provider is bound for class $modelClass"
            }
        } catch (cce: ClassCastException) {
            error("Wrong provider type registered for ViewModel type $modelClass")
        }
}