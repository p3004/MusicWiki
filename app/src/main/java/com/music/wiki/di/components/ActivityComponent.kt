package com.music.wiki.di.components

import com.music.wiki.di.ActivityScope
import com.music.wiki.di.modules.ActivityModule
import com.music.wiki.ui.genres.main.MainActivity
import dagger.Component

/**
 * Created by Pallab Banerjee on 2/23/2021.
 */

@ActivityScope
@Component(
    modules = [ActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
interface ActivityComponent {

    fun inject(activity : MainActivity)

}