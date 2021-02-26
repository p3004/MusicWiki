package com.music.wiki.data.model.info.album

import com.google.gson.annotations.SerializedName

data class Albums(
    @SerializedName("album")
    val albumItem: List<AlbumItem>
)