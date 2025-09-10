package com.defey.testcourse.favorite_screen.di

import androidx.fragment.app.Fragment
import com.defey.testcourse.di.ComponentHolder
import com.defey.testcourse.di.findDependencies

class FavoriteScreenComponentHolder : ComponentHolder<FavoriteScreenComponent, Fragment>(
    creator = { fragment ->
        DaggerFavoriteScreenComponent.factory()
            .create(fragment.findDependencies())
    }
)