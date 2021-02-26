package com.music.wiki.data.model.info.track

import com.google.gson.annotations.SerializedName

/**
 * Created by Pallab Banerjee on 2/26/2021.
 */
data class Track(
    @SerializedName("tracks")
    val track: Tracks

)