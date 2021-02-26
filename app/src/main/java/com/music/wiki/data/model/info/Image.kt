package com.music.wiki.data.model.info

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("#text")
    val url: String,

    @SerializedName("size")
    val size: String
)