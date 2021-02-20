package com.music.wiki.di.components

import com.music.wiki.WikiApplication
import com.music.wiki.data.remote.ApiService
import com.music.wiki.di.modules.ApplicationModule
import com.music.wiki.utils.network.NetworkHelper
import com.music.wiki.utils.rx.SchedulerProvider
import dagger.Component
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by Pallab Banerjee on 2/20/2021.
 */
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application : WikiApplication)

    fun getNetworkHelper() : NetworkHelper

    fun getSchedulerProvider() : SchedulerProvider

    fun getCompositeDisposable() : CompositeDisposable

    fun getApiService() : ApiService

}