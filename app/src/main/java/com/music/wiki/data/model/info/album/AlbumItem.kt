package com.music.wiki.data.model.info.album

import com.google.gson.annotations.SerializedName
import com.music.wiki.data.model.info.Image

data class AlbumItem(
    @SerializedName("image")
    val image: List<Image>,

    @SerializedName("name")
    val name: String
)