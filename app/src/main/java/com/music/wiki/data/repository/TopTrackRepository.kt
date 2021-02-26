package com.music.wiki.data.repository

import com.music.wiki.data.model.info.track.Track
import com.music.wiki.data.remote.ApiService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Created by Pallab Banerjee on 2/26/2021.
 */
class TopTrackRepository @Inject constructor(private val apiService: ApiService)  {

    fun getTrackRepository(tag : String) : Single<Track> = apiService.getTrackList(tag = tag)

}