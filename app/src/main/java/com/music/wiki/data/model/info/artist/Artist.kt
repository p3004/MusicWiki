package com.music.wiki.data.model.info.artist

import com.google.gson.annotations.SerializedName

/**
 * Created by Pallab Banerjee on 2/26/2021.
 */
data class Artist(
    @SerializedName("topartists")
    val topArtists : Artists
)