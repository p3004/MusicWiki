package com.music.wiki.data.model.top

import com.google.gson.annotations.SerializedName

/**
 * Created by Pallab Banerjee on 2/21/2021.
 */
data class TopGenre(

    @SerializedName("toptags")
    val toptags : TopTags

)