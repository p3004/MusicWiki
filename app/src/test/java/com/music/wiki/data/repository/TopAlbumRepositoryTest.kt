package com.music.wiki.data.repository

import com.music.wiki.data.model.info.album.Album
import com.music.wiki.data.model.info.album.Albums
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
 * Created by Pallab Banerjee on 2/26/2021.
 */

@RunWith(MockitoJUnitRunner::class)
class TopAlbumRepositoryTest {


    @Mock
    lateinit var apiService: ApiService

    private lateinit var album : Album

    private lateinit var topAlbumRepository : TopAlbumRepository

    @Before
    fun setUp(){
        album = Album(Albums(emptyList()))
        topAlbumRepository = TopAlbumRepository(apiService)
    }


    @Test
    fun whenCalledGetTopAlbumRepository_shouldCallGetAlbumListFromApiService(){
        doReturn(Single.just(album))
            .`when`(apiService)
            .getAlbumList(tag ="")

        topAlbumRepository.getTopAlbumRepository("")

        verify(apiService).getAlbumList(tag = "")

    }


}