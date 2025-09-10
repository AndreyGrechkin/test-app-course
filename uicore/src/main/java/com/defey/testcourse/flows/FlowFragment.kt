package com.defey.testcourse.flows

import android.os.Bundle
import com.defey.testcourse.navigation.AppRootRouter
import com.defey.testcourse.navigation.OnBackPressHandler
import com.defey.testcourse.navigation.setLaunchScreen
import com.defey.testcourse.uicore.R
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

abstract class FlowFragment() : BaseFragment(R.layout.layout_container) {

    private val currentFragment
        get() = childFragmentManager.fragments.lastOrNull() as? OnBackPressHandler

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: AppRootRouter

    private val navigator: Navigator by lazy {
        object : AppNavigator(requireActivity(), R.id.container, childFragmentManager) {
            override fun activityBack() {
                onBackPressed()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createScreen()
    }

    open fun createScreen() {
        if (childFragmentManager.fragments.isEmpty()) {
            navigator.setLaunchScreen(getLaunchScreen())
        }
    }

    abstract fun getLaunchScreen(): Screen

    override fun onBackPressed() {
        if (childFragmentManager.fragments.count() > 1) {
            currentFragment?.onBackPressed()
        } else {
            router.exit()
        }
    }

    override fun onResume() {
        super.onResume()

        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()

        super.onPause()
    }
}