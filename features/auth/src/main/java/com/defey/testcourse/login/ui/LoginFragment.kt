package com.defey.testcourse.login.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.defey.testcourse.auth.databinding.FragmentLoginBinding
import com.defey.testcourse.di.componentHolder
import com.defey.testcourse.flows.BaseViewBindingFragment
import com.defey.testcourse.login.di.LoginComponentHolder
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class LoginFragment : BaseViewBindingFragment<FragmentLoginBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<LoginViewModel> { viewModelFactory }

    private val componentHolder by componentHolder<LoginComponentHolder>()

    override fun onAttach(context: Context) {
        componentHolder.getDaggerComponent(this).inject(this)

        super.onAttach(context)
    }


    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

    override fun setupListeners() {
        binding.signInButton.setOnClickListener {
            viewModel.handleEvent(LoginUiContract.Event.OnCourses)
        }
    }

    companion object {
        fun newInstance() = object : FragmentScreen {
            override fun createFragment(factory: FragmentFactory): Fragment {
                return LoginFragment()
            }
        }
    }
}