package com.defey.testcourse.navigation

import android.content.Intent
import com.github.terrakok.cicerone.ResultListener
import com.github.terrakok.cicerone.ResultListenerHandler
import com.github.terrakok.cicerone.Screen

interface FlowRouter {
    fun setResultListener(
        key: String,
        listener: ResultListener
    ): ResultListenerHandler

    fun sendResult(key: String, data: Any)
    fun navigateInsideFlowTo(screen: Screen)
    fun replaceScreen(screen: Screen)
    fun startFlow(flow: FeatureFlow)
    fun replaceCurrentFlow(flow: FeatureFlow)
    fun newRootFlow(flow: FeatureFlow)
    fun finishFlow()
    fun back()
    fun back(screen: Screen?)
    fun navigateToActivityByIntent(intent: Intent)
}