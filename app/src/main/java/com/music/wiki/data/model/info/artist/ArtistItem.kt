package com.music.wiki.data.model.info.artist

import com.google.gson.annotations.SerializedName
import com.music.wiki.data.model.info.Image

data class ArtistItem(
    @SerializedName("image")
    val image: List<Image>,

    @SerializedName("name")
    val name: String
)