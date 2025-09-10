package com.defey.testcourse.flow.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.defey.testcourse.courses.R
import com.defey.testcourse.courses.databinding.FragmentCoursesBinding
import com.defey.testcourse.di.ComponentDependenciesMap
import com.defey.testcourse.di.HasComponentDependencies
import com.defey.testcourse.di.componentHolder
import com.defey.testcourse.favorite_screen.ui.FavoriteScreenFragment
import com.defey.testcourse.flow.di.CoursesFlowComponentHolder
import com.defey.testcourse.flows.BaseViewBindingFragment
import com.defey.testcourse.main_screen.ui.MainScreenFragment
import com.defey.testcourse.navigation.AppRootRouter
import com.defey.testcourse.navigation.OnBackPressHandler
import com.defey.testcourse.navigation.setLaunchScreen
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class CoursesFlowFragment : BaseViewBindingFragment<FragmentCoursesBinding>(),
    HasComponentDependencies {

    private val currentFragment
        get() = childFragmentManager.fragments.lastOrNull() as? OnBackPressHandler
    private val componentHolder by componentHolder<CoursesFlowComponentHolder>()

    @Inject
    override lateinit var dependencies: ComponentDependenciesMap

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: AppRootRouter

    private val childNavigator by lazy {
        object : AppNavigator(requireActivity(), R.id.home_container, childFragmentManager) {
            override fun activityBack() {
                onBackPressed()
            }
        }
    }

    override fun onAttach(context: Context) {
        componentHolder.getDaggerComponent(this).inject(this)

        super.onAttach(context)
    }

    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentCoursesBinding {
        return FragmentCoursesBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigatorHolder.setNavigator(childNavigator)
        setupBottomNavigation()
        if (savedInstanceState == null) {
            showHomeFragment()
        }
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    showHomeFragment()
                    true
                }

                R.id.navigation_favorites -> {
                    showFavoritesFragment()
                    true
                }

                R.id.navigation_profile -> {
                    showProfileFragment()
                    true
                }

                else -> false
            }
        }
    }

    private fun showHomeFragment() {
        childNavigator.setLaunchScreen(MainScreenFragment.newInstance())
    }

    private fun showFavoritesFragment() {
        childNavigator.setLaunchScreen(FavoriteScreenFragment.newInstance())
    }

    private fun showProfileFragment() {

    }

    override fun onBackPressed() {
        if (childFragmentManager.fragments.count() > 1) {
            currentFragment?.onBackPressed()
        } else {
            router.exit()
        }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(childNavigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    companion object {
        fun newInstance() = object : FragmentScreen {
            override fun createFragment(factory: FragmentFactory): Fragment {
                return CoursesFlowFragment()
            }
        }
    }
}