package com.defey.testcourse.flows

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.defey.testcourse.navigation.OnBackPressHandler

abstract class BaseFragment(
    @LayoutRes open val contentLayoutId: Int = 0,
) : Fragment(contentLayoutId), OnBackPressHandler {

    override fun onBackPressed() {}
}