package com.defey.testcourse.main_screen.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.defey.testcourse.adapter.bindWith
import com.defey.testcourse.adapter.binderAdapterOf
import com.defey.testcourse.adapter.updateItems
import com.defey.testcourse.courses.databinding.FragmentMainScreenBinding
import com.defey.testcourse.di.componentHolder
import com.defey.testcourse.flow.ui.CourseItemCellViewDisplayItem
import com.defey.testcourse.flow.ui.CourseItemCellViewHolderFactory
import com.defey.testcourse.flows.BaseViewBindingFragment
import com.defey.testcourse.main_screen.di.MainScreenComponentHolder
import com.github.terrakok.cicerone.androidx.FragmentScreen
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
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

    override fun setupViewModelObserving() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collectLatest { updateState(it) }
        }
    }

    override fun setupViews() {
        setupRecyclerView()
    }

    override fun setupListeners() {
        binding.sortingButton.setOnClickListener {
            viewModel.handleEvent(MainScreenUiContract.Event.OnSortedCourses)
        }
    }

    private fun setupRecyclerView() {
        with(binding.recyclerView) {
            adapter = binderAdapterOf(
                CourseItemCellViewDisplayItem::class bindWith CourseItemCellViewHolderFactory(
                    onFavoriteClick = {
                        viewModel.handleEvent(MainScreenUiContract.Event.OnFavorite(it))
                    }
                )
            )
            itemAnimator = null
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun updateState(state: MainScreenUiContract.State) = with(binding) {
        recyclerView.updateItems(state.courses)
    }

    companion object {
        fun newInstance() = object : FragmentScreen {
            override fun createFragment(factory: FragmentFactory): Fragment {
                return MainScreenFragment()
            }
        }
    }
}