package com.music.wiki.data.model

import com.google.gson.annotations.SerializedName

data class TopTags(
    @SerializedName("tag")
    val tag: List<Tag>
)