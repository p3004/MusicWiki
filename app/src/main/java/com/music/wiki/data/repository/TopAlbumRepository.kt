package com.music.wiki.data.repository

import com.music.wiki.data.model.info.album.Album
import com.music.wiki.data.remote.ApiService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Created by Pallab Banerjee on 2/26/2021.
 */
class TopAlbumRepository @Inject constructor(private val apiService: ApiService)  {

    fun getTopAlbumRepository(tag : String) : Single<Album>  = apiService.getAlbumList(tag = tag)

}