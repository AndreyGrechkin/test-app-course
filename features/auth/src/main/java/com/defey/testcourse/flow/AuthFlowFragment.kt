package com.defey.testcourse.flow

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.defey.testcourse.login.ui.LoginFragment
import com.defey.testcourse.di.ComponentDependenciesMap
import com.defey.testcourse.di.HasComponentDependencies
import com.defey.testcourse.di.componentHolder
import com.defey.testcourse.flows.FlowFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class AuthFlowFragment : FlowFragment(), HasComponentDependencies {

    private val componentHolder by componentHolder<AuthFlowComponentHolder>()

    @Inject
    override lateinit var dependencies: ComponentDependenciesMap

    override fun onAttach(context: Context) {
        componentHolder.getDaggerComponent(this).inject(this)

        super.onAttach(context)
    }

    override fun getLaunchScreen(): Screen {
        return LoginFragment.Companion.newInstance()
    }

    companion object {
        fun newInstance() = object : FragmentScreen {
            override fun createFragment(factory: FragmentFactory): Fragment {
                return AuthFlowFragment()
            }
        }
    }
}