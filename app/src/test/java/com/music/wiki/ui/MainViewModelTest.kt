package com.music.wiki.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.music.wiki.data.model.top.TopGenre
import com.music.wiki.data.model.top.TopTags
import com.music.wiki.data.repository.TopGenreRepository
import com.music.wiki.ui.genres.main.MainViewModel
import com.music.wiki.utils.TestSchedulerProvider
import com.music.wiki.utils.common.Resource
import com.music.wiki.utils.network.NetworkHelperImpl
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.TestScheduler
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import kotlin.Exception

/**
 * Created by Pallab Banerjee on 2/21/2021.
 */

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get: Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var networkHelperImpl: NetworkHelperImpl

    @Mock
    private lateinit var topGenreRepository: TopGenreRepository

    @Mock
    private lateinit var topGenreObserver : Observer<Resource<TopGenre>>

    private lateinit var testScheduler : TestScheduler

    private lateinit var mainViewModel: MainViewModel

    private lateinit var topGenre: TopGenre



    @Before
    fun setUp(){

        topGenre = TopGenre(TopTags(listOf()))
        val compositeDisposable = CompositeDisposable()
        testScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(testScheduler)
        mainViewModel = MainViewModel(networkHelperImpl,
        topGenreRepository,
        compositeDisposable,
        testSchedulerProvider
        )
        mainViewModel.topGenreListLiveData.observeForever(topGenreObserver)
    }


    @Test
    fun givenNoInternet_whenGetTopGenreFromApiCalled_shouldShowNetworkError(){

        doReturn(false)
            .`when`(networkHelperImpl)
            .checkIsNetworkConnected()

        mainViewModel.getTopGenreFromApi()

        verify(topGenreObserver).onChanged(Resource.error("No Internet Connection!"))
    }

    @Test
    fun givenServerResponse200_whenGetTopGenreFromApiCalled_shouldExposeTopGenreViaLiveData(){

            doReturn(true)
                .`when`(networkHelperImpl)
                .checkIsNetworkConnected()

            doReturn(Single.just(topGenre))
                .`when`(topGenreRepository)
                .getTopGenre()

            mainViewModel.getTopGenreFromApi()
            testScheduler.triggerActions()
            verify(topGenreObserver).onChanged(Resource.success(topGenre))

    }


    @Test
    fun givenServerError_whenTopGenreFromApiCalled_shouldShowError(){

        doReturn(true)
            .`when`(networkHelperImpl)
            .checkIsNetworkConnected()

        doReturn(Single.error<Exception>(Exception("Error")))
            .`when`(topGenreRepository)
            .getTopGenre()

        mainViewModel.getTopGenreFromApi()
        testScheduler.triggerActions()
        verify(topGenreObserver).onChanged(Resource.error("Error"))


    }


    @After
    fun tearDown(){
        mainViewModel.topGenreListLiveData.removeObserver(topGenreObserver)
    }

}