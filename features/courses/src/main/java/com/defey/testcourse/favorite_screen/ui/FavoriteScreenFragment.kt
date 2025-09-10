package com.defey.testcourse.favorite_screen.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.defey.testcourse.courses.databinding.FragmentFavoriteScreenBinding
import com.defey.testcourse.courses.databinding.FragmentMainScreenBinding
import com.defey.testcourse.di.componentHolder
import com.defey.testcourse.favorite_screen.di.FavoriteScreenComponentHolder
import com.defey.testcourse.flows.BaseViewBindingFragment
import com.defey.testcourse.main_screen.di.MainScreenComponentHolder
import com.defey.testcourse.main_screen.ui.MainScreenFragment
import com.defey.testcourse.main_screen.ui.MainScreenViewModel
import com.github.terrakok.cicerone.androidx.FragmentScreen
import javax.inject.Inject
import kotlin.getValue

class FavoriteScreenFragment : BaseViewBindingFragment<FragmentFavoriteScreenBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<FavoriteScreenViewModel> { viewModelFactory }

    private val componentHolder by componentHolder<FavoriteScreenComponentHolder>()

    override fun onAttach(context: Context) {
        componentHolder.getDaggerComponent(this).inject(this)

        super.onAttach(context)
    }


    override fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentFavoriteScreenBinding {
        return FragmentFavoriteScreenBinding.inflate(inflater, container, false)
    }

    companion object {
        fun newInstance() = object : FragmentScreen {
            override fun createFragment(factory: FragmentFactory): Fragment {
                return FavoriteScreenFragment()
            }
        }
    }
}