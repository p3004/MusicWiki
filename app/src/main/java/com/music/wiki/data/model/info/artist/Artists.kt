package com.music.wiki.data.model.info.artist

import com.google.gson.annotations.SerializedName

data class Artists(
    @SerializedName("artist")
    val artistItem: List<ArtistItem>
)