package com.dou.kotlinexam.model
import com.google.gson.annotations.SerializedName


/**
 * Created by nnbinh on 11/27/17.
 */
data class ChannelListResponse(
        @SerializedName("responseMessage") var responseMessage: String? = "",
        @SerializedName("responseCode") var responseCode: String? = "",
        @SerializedName("channels") var channels: List<Channel> = listOf()
)