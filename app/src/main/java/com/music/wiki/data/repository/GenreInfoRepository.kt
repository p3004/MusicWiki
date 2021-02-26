package com.music.wiki.data.repository

import com.music.wiki.data.model.info.tag.Tags
import com.music.wiki.data.remote.ApiService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Created by Pallab Banerjee on 2/26/2021.
 */
class GenreInfoRepository @Inject constructor(private val apiService: ApiService) {

    fun getGenreInfo( tag : String) : Single<Tags> = apiService.getTagInfo(tag = tag)

}