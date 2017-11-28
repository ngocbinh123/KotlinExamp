package com.dou.kotlinexam.database.model

import com.dou.kotlinexam.database.AppDatabase
import com.google.gson.annotations.SerializedName
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel

/**
 * Created by nnbinh on 11/27/17.
 */
@Table(name = "Channel", database = AppDatabase::class)
data class Channel(
        @PrimaryKey
        @Column(name = "id")
        @SerializedName("channelId") var id: Int = 0,
        @Column(name = "title")
        @SerializedName("channelTitle") var title: String = "",
        @Column(name = "stbNumber")
        @SerializedName("channelStbNumber") var stbNumber: Int = 0,
        var isFavorite: Boolean = false
)  : BaseModel()
