package com.defey.testcourse.main_screen.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.defey.testcourse.courses.databinding.FragmentMainScreenBinding
import com.defey.testcourse.di.componentHolder
import com.defey.testcourse.flows.BaseViewBindingFragment
import com.defey.testcourse.main_screen.di.MainScreenComponentHolder
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject

class MainScreenFragment : BaseViewBindingFragment<FragmentMainScreenBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<MainScreenViewModel> { viewModelFactory }

    private val componentHolder by componentHolder<MainScreenComponentHolder>()

    override fun onAttach(context: Context) {
        componentHolder.getDaggerComponent(this).inject(this)

        super.onAttach(context)
    }


    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentMainScreenBinding {
        return FragmentMainScreenBinding.inflate(inflater, container, false)
    }

    override fun setupViews() {
        viewModel.fetchInitData()
    }

    companion object {
        fun newInstance() = object : FragmentScreen {
            override fun createFragment(factory: FragmentFactory): Fragment {
                return MainScreenFragment()
            }
        }
    }
}