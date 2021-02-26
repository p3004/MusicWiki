package com.music.wiki.data.model.top

import com.google.gson.annotations.SerializedName
import com.music.wiki.data.model.top.Tag

data class TopTags(
    @SerializedName("tag")
    val tag: List<Tag>
)