package com.music.wiki.ui.genres.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.music.wiki.data.model.top.TopGenre
import com.music.wiki.data.repository.TopGenreRepository
import com.music.wiki.utils.common.Resource
import com.music.wiki.utils.network.NetworkHelper
import com.music.wiki.utils.rx.SchedulerProvider
import io.reactivex.rxjava3.disposables.CompositeDisposable

/**
 * Created by Pallab Banerjee on 2/21/2021.
 */
/**
 * used to get data from repository and feed into view via livedata observables
* */

class MainViewModel(
    private val networkHelper: NetworkHelper,
    private val topGenreRepository: TopGenreRepository,
    private val compositeDisposable: CompositeDisposable,
    private val schedulerProvider: SchedulerProvider
) : ViewModel() {

    private val _topGenreListLiveData: MutableLiveData<Resource<TopGenre>> = MutableLiveData()
    val topGenreListLiveData: LiveData<Resource<TopGenre>> = _topGenreListLiveData


    fun getTopGenreFromApi() {

        if (networkHelper.checkIsNetworkConnected()) {

            _topGenreListLiveData.postValue(Resource.loading(null))
            compositeDisposable.addAll(
                topGenreRepository.getTopGenre()
                    .subscribeOn(schedulerProvider.io())
                    .subscribe(
                        {
                            _topGenreListLiveData.postValue(Resource.success(it))
                        },
                        {
                            _topGenreListLiveData.postValue(Resource.error(it.message))
                        }
                    )
            )
        }else{
            _topGenreListLiveData.postValue(Resource.error("No Internet Connection!"))
        }
    }


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}