package com.music.wiki.data.repository

import com.music.wiki.data.model.info.track.Track
import com.music.wiki.data.model.info.track.Tracks
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
class TopTrackRepositoryTest {

    @Mock
    lateinit var apiService: ApiService

    private lateinit var track : Track

    private lateinit var topTrackRepository: TopTrackRepository


    @Before
    fun setUp(){

        track = Track(Tracks(emptyList()))
        topTrackRepository = TopTrackRepository(apiService)

    }


    @Test
    fun whenCalledGetTopArtist_shouldCallGetTrackListFromApiService(){

        doReturn(Single.just(track))
            .`when`(apiService)
            .getTrackList(tag =  "")

        topTrackRepository.getTrackRepository("")

        verify(apiService).getTrackList(tag = "")


    }

}