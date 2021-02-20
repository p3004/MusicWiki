package com.music.wiki.data.remote

import com.music.wiki.BuildConfig
import com.music.wiki.data.model.TopGenre
import com.music.wiki.data.model.TopTags
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Pallab Banerjee on 2/20/2021.
 */
interface ApiService {

    @GET("")
    fun getTopTags(
        @Query("method") method : String = "tag.getTopTags",
        @Query("api_key") api_key : String = BuildConfig.API_KEY,
        @Query("format") format : String = "json"
    ) : Single<TopGenre>

}