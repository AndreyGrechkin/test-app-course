package com.defey.testcourse.login.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.defey.testcourse.auth.databinding.FragmentLoginBinding
import com.defey.testcourse.di.componentHolder
import com.defey.testcourse.flows.BaseViewBindingFragment
import com.defey.testcourse.login.di.LoginComponentHolder
import com.github.terrakok.cicerone.androidx.FragmentScreen
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
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

    override fun setupViewModelObserving() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collectLatest { updateState(it) }
        }
    }

    override fun setupListeners() = with(binding) {
        emailEditText.doAfterTextChanged {
            viewModel.handleEvent(LoginUiContract.Event.UpdateEmail(it?.toString()))
        }
        passwordEditText.doAfterTextChanged {
            viewModel.handleEvent(LoginUiContract.Event.UpdatePassword(it?.toString()))
        }
        signInButton.setOnClickListener {
            viewModel.handleEvent(LoginUiContract.Event.OnCourses)
        }
        vkButton.setOnClickListener {
            viewModel.handleEvent(LoginUiContract.Event.NavigateToVk)
        }
        okButton.setOnClickListener {
            viewModel.handleEvent(LoginUiContract.Event.NavigateToOk)
        }
    }

    private fun updateState(state: LoginUiContract.State) = with(binding) {
        signInButton.isEnabled = state.isLoginAvailable
    }

    companion object {
        fun newInstance() = object : FragmentScreen {
            override fun createFragment(factory: FragmentFactory): Fragment {
                return LoginFragment()
            }
        }
    }
}