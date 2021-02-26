package com.music.wiki.data.model.info.album

import com.google.gson.annotations.SerializedName

/**
 * Created by Pallab Banerjee on 2/26/2021.
 */
data class Album(

    @SerializedName("albums")
    val albums : Albums

)