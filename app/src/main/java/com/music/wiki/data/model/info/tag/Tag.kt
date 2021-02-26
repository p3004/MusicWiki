package com.music.wiki.data.model.info.tag

import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("name")
    val name: String,

    @SerializedName("wiki")
    val wiki: Wiki
)