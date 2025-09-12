package com.defey.testcourse.favorite_screen.ui

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
import com.defey.testcourse.courses.databinding.FragmentFavoriteScreenBinding
import com.defey.testcourse.di.componentHolder
import com.defey.testcourse.favorite_screen.di.FavoriteScreenComponentHolder
import com.defey.testcourse.flow.ui.CourseItemCellViewDisplayItem
import com.defey.testcourse.flow.ui.CourseItemCellViewHolderFactory
import com.defey.testcourse.flows.BaseViewBindingFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

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

    override fun setupViewModelObserving() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collectLatest { updateState(it) }
        }
    }

    override fun setupViews() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(binding.recyclerView) {
            adapter = binderAdapterOf(
                CourseItemCellViewDisplayItem::class bindWith CourseItemCellViewHolderFactory(
                    onFavoriteClick = {
                        viewModel.handleEvent(FavoriteScreenUiContract.Event.OnDeleteFavorite(it))
                    }
                )
            )
            itemAnimator = null
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun updateState(state: FavoriteScreenUiContract.State) = with(binding) {
        recyclerView.updateItems(state.courses)
    }

    companion object {
        fun newInstance() = object : FragmentScreen {
            override fun createFragment(factory: FragmentFactory): Fragment {
                return FavoriteScreenFragment()
            }
        }
    }
}