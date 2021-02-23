package com.music.wiki.di.modules

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.music.wiki.data.repository.TopGenreRepository
import com.music.wiki.ui.genres.main.MainViewModel
import com.music.wiki.utils.ViewModelProviderFactory
import com.music.wiki.utils.network.NetworkHelper
import com.music.wiki.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.disposables.CompositeDisposable

/**
 * Created by Pallab Banerjee on 2/23/2021.
 */

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    fun provideMainViewModel(
        networkHelper: NetworkHelper,
        topGenreRepository: TopGenreRepository,
        compositeDisposable: CompositeDisposable,
        schedulerProvider: SchedulerProvider
    ): MainViewModel = ViewModelProvider(activity, ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(networkHelper, topGenreRepository, compositeDisposable, schedulerProvider)
        }).get(MainViewModel::class.java)

}