package com.defey.testcourse.flows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

abstract class BaseViewBindingFragment<VB : ViewBinding> : BaseFragment() {

    private var _binding: VB? = null
    protected val binding: VB
        get() = requireNotNull(_binding)

    abstract fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = inflateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupViewModelObserving()
        setupListeners()
    }

    override fun onPause() {
        super.onPause()

        binding.root.clearFocus()
    }

    open fun setupViews() {}
    open fun setupViewModelObserving() {}
    open fun setupListeners() {}
}