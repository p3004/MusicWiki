package com.music.wiki.data.model.info.track

import com.google.gson.annotations.SerializedName
import com.music.wiki.data.model.info.Image

data class TrackItem(
    @SerializedName("duration")
    val duration: String,

    @SerializedName("image")
    val image: List<Image>,

    @SerializedName("url")
    val url: String
)