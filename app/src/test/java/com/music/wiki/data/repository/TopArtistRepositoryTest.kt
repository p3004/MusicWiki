package com.music.wiki.data.repository

import com.music.wiki.data.model.info.artist.Artist
import com.music.wiki.data.model.info.artist.Artists
import com.music.wiki.data.remote.ApiService
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Pallab Banerjee on 3/2/2021.
 */

@RunWith(MockitoJUnitRunner::class)
class TopArtistRepositoryTest {

    @Mock
    lateinit var apiService : ApiService

    private lateinit var artist: Artist

    private lateinit var topArtistRepository: TopArtistRepository

    @Before
    fun setUp(){
        artist = Artist(Artists(emptyList()))
        topArtistRepository = TopArtistRepository(apiService)
    }


    @Test
    fun whenCalledGetTopArtist_shouldCallGetArtistListFromApiService(){

        doReturn(Single.just(artist))
            .`when`(apiService)
            .getArtistList(tag = "")

        topArtistRepository.getTopArtist("")

        verify(apiService).getArtistList(tag = "")

    }

}