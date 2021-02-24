package com.music.wiki.di.modules

import com.music.wiki.WikiApplication
import com.music.wiki.data.remote.ApiService
import com.music.wiki.data.remote.RetrofitNetworking
import com.music.wiki.utils.network.NetworkHelper
import com.music.wiki.utils.network.NetworkHelperImpl
import com.music.wiki.utils.rx.RxSchedulerProvider
import com.music.wiki.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by Pallab Banerjee on 2/20/2021.
 */

@Module
class ApplicationModule(private val application: WikiApplication) {

    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelperImpl(application)


    @Provides
    fun provideRxSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()


    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Singleton
    @Provides
    fun provideApiService() : ApiService = RetrofitNetworking.create()

}