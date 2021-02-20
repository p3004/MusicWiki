package com.music.wiki.data.repository

import com.music.wiki.data.model.TopGenre
import com.music.wiki.data.model.TopTags
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
 * Created by Pallab Banerjee on 2/21/2021.
 */

@RunWith(MockitoJUnitRunner::class)
class TopGenreRepositoryTest {

    @Mock
    lateinit var apiService: ApiService

    private lateinit var topGenreRepository: TopGenreRepository

    private lateinit var topGenre: TopGenre


    @Before
    fun setUp() {

        topGenre = TopGenre(TopTags(emptyList()))

        topGenreRepository = TopGenreRepository(apiService)


    }


    @Test
    fun whenGetTopGenreCalled_shouldRequestGetTopTagsFromApiService(){

        doReturn(Single.just(topGenre))
            .`when`(apiService)
            .getTopTags()

        topGenreRepository.getTopGenre()

        verify(apiService).getTopTags()

    }



}