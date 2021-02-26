package com.music.wiki.data.model.info.track

import com.google.gson.annotations.SerializedName

data class Tracks(
    @SerializedName("track")
    val trackItem: List<TrackItem>
)