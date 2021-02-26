package com.music.wiki.data.model.info.tag

import com.google.gson.annotations.SerializedName

data class Wiki(
    @SerializedName("summary")
    val summary: String
)