package com.music.wiki.data.model.info.tag

import com.google.gson.annotations.SerializedName


data class Tags(
    @SerializedName("tag")
    val tag: Tag
)