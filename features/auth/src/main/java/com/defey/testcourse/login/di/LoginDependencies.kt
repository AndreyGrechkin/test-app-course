package com.defey.testcourse.login.di

import androidx.lifecycle.ViewModelProvider
import com.defey.testcourse.di.ComponentDependencies
import com.defey.testcourse.flows.CommonFlowDependencies


interface LoginDependencies : ComponentDependencies, CommonFlowDependencies {
    val factory: ViewModelProvider.Factory

}