package com.defey.testcourse

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.defey.testcourse.di.ComponentDependenciesMap
import com.defey.testcourse.di.HasComponentDependencies
import com.defey.testcourse.di.MainComponentHolder
import com.defey.testcourse.di.componentHolder
import com.defey.testcourse.flow.AuthFlowFragment
import com.defey.testcourse.navigation.AppRootRouter
import com.defey.testcourse.navigation.OnBackPressHandler
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasComponentDependencies {

    private val componentHolder by componentHolder<MainComponentHolder>()
    private val navigator: Navigator = AppNavigator(this, R.id.container)

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: AppRootRouter

    @Inject
    override lateinit var dependencies: ComponentDependenciesMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        componentHolder.getDaggerComponent(this).inject(this)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                handleBackPress()
            }
        })

        if (savedInstanceState == null) {
            router.newRootScreen(AuthFlowFragment.newInstance())
        }
    }

    private fun handleBackPress() {
        val containerFragment = supportFragmentManager.findFragmentById(R.id.container)
        val childBackStackEntryCount =
            containerFragment?.childFragmentManager?.backStackEntryCount ?: 0

        if (childBackStackEntryCount > 0) {
            containerFragment?.childFragmentManager?.popBackStack()
        } else {
            val currentFragment = containerFragment as? OnBackPressHandler
            currentFragment?.onBackPressed() ?: router.exit()
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

    override fun onDestroy() {
        super.onDestroy()
        componentHolder.clear()
    }
}