package com.defey.testcourse.flows

import com.defey.testcourse.navigation.AppRootRouter
import com.defey.testcourse.navigation.RootScreenRouter

interface CommonFlowDependencies {
    val rootScreenRouter: RootScreenRouter
    val router: AppRootRouter
}