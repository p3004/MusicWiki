package com.music.wiki.data.remote

import com.music.wiki.BuildConfig
import com.music.wiki.data.model.info.album.Album
import com.music.wiki.data.model.info.artist.Artist
import com.music.wiki.data.model.info.tag.Tags
import com.music.wiki.data.model.info.track.Track
import com.music.wiki.data.model.top.TopGenre
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Pallab Banerjee on 2/20/2021.
 */
interface ApiService {

    @GET("2.0/")
    fun getTopTags(
        @Query("method") method : String = "tag.getTopTags",
        @Query("api_key") api_key : String = BuildConfig.API_KEY,
        @Query("format") format : String = "json"
    ) : Single<TopGenre>

    @GET("2.0/")
    fun getTagInfo(
        @Query("method") method : String = "tag.getinfo",
        @Query("tag") tag : String,
        @Query("api_key") api_key : String = BuildConfig.API_KEY,
        @Query("format") format : String = "json"
    ) : Single<Tags>


    @GET("2.0/")
    fun getAlbumList(
        @Query("method") method : String = "tag.gettopalbums",
        @Query("tag") tag : String,
        @Query("api_key") api_key : String = BuildConfig.API_KEY,
        @Query("format") format : String = "json"
    ) : Single<Album>


    @GET("2.0/")
    fun getArtistList(
        @Query("method") method : String = "tag.gettopartists",
        @Query("tag") tag : String,
        @Query("api_key") api_key : String = BuildConfig.API_KEY,
        @Query("format") format : String = "json"
    ) : Single<Artist>


    @GET("2.0/")
    fun getTrackList(
        @Query("method") method : String = "tag.gettoptracks",
        @Query("tag") tag : String,
        @Query("api_key") api_key : String = BuildConfig.API_KEY,
        @Query("format") format : String = "json"
    ) : Single<Track>

}