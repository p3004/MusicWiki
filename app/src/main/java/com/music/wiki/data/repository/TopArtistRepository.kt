package com.music.wiki.data.repository

import com.music.wiki.data.model.info.artist.Artist
import com.music.wiki.data.remote.ApiService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Created by Pallab Banerjee on 2/26/2021.
 */
class TopArtistRepository @Inject constructor(private val apiService: ApiService) {

    fun getTopArtist(tag : String) : Single<Artist> = apiService.getArtistList(tag = tag)

}