package com.music.wiki.data.repository

import com.music.wiki.data.model.info.tag.Tag
import com.music.wiki.data.model.info.tag.Tags
import com.music.wiki.data.model.info.tag.Wiki
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
class GenreInfoRepositoryTest {

    @Mock
    lateinit var apiService: ApiService

    private lateinit var tags : Tags

    private lateinit var genreInfoRepository: GenreInfoRepository


    @Before
    fun setUp(){
        tags = Tags(Tag("", Wiki("")))
        genreInfoRepository = GenreInfoRepository(apiService)

    }

    @Test
    fun whenCalledGetGenreInfo_shouldCallGetTagInfoFromApiService(){

        doReturn(Single.just(tags))
            .`when`(apiService)
            .getTagInfo(tag = "")

        genreInfoRepository.getGenreInfo("")

        verify(apiService).getTagInfo(tag = "")

    }


}