package com.music.wiki.data.repository

import com.music.wiki.data.model.top.TopGenre
import com.music.wiki.data.remote.ApiService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Created by Pallab Banerjee on 2/21/2021.
 */
/**
 * Repository to call the api to fetch top tags or genres from Last.fm
* */

class TopGenreRepository@Inject constructor(
    private val apiService: ApiService
) {

    fun getTopGenre() : Single<TopGenre> = apiService.getTopTags()

}