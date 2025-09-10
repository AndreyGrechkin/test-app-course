package com.defey.testcourse.navigation

import android.content.Context
import android.content.Intent
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.ActivityScreen

class AppFlowRouter(
    private val appRouter: Router,
    private val  rootScreenRouter: RootScreenRouter
) : Router(), FlowRouter {

    override fun navigateInsideFlowTo(screen: Screen) {
        navigateTo(screen)
    }

    override fun startFlow(flow: FeatureFlow) {
        appRouter.navigateTo(flow)
    }

    override fun replaceCurrentFlow(flow: FeatureFlow) {
        appRouter.replaceScreen(flow)
    }

    override fun newRootFlow(flow: FeatureFlow) {
        appRouter.newRootScreen(flow)
    }

    override fun finishFlow() {
        appRouter.exit()
    }

    override fun back() {
        exit()
    }

    override fun back(screen: Screen?) {
        backTo(screen)
    }

    override fun navigateToActivityByIntent(intent: Intent) {
        navigateTo(object : ActivityScreen {
            override fun createIntent(context: Context): Intent {
                return intent
            }
        })
    }

    override fun navigateNewRootScreen(screen: RootScreen) {
        rootScreenRouter.navigateNewRootScreen(screen)
    }
}