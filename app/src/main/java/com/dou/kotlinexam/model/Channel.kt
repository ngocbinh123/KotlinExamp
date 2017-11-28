package com.dou.kotlinexam.model

import com.google.gson.annotations.SerializedName

/**
 * Created by nnbinh on 11/27/17.
 */

data class Channel(
        @SerializedName("channelId") var id: Int = 0,
        @SerializedName("channelTitle") var title: String = "",
        @SerializedName("channelStbNumber") var stbNumber: Int = 0,
        var isFavorite: Boolean = false
)
