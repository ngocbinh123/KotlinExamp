package com.dou.kotlinexam.model

import android.databinding.Bindable
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry
import com.dou.kotlinexam.BR
import com.google.gson.annotations.SerializedName

/**
 * Created by nnbinh on 11/27/17.
 */

data class Channel(
        @SerializedName("channelId") var id: Int = 0,
        @SerializedName("channelTitle") var title: String = "",
        @SerializedName("channelStbNumber") var stbNumber: Int = 0) : Observable {
    private val registry: PropertyChangeRegistry = PropertyChangeRegistry()
    override fun removeOnPropertyChangedCallback(p0: Observable.OnPropertyChangedCallback?) {
        registry.remove(p0)
    }

    override fun addOnPropertyChangedCallback(p0: Observable.OnPropertyChangedCallback?) {
        registry.add(p0)
    }

    @get: Bindable
    var isFavorite: Boolean = false
        set(value) {
            field = value
            registry.notifyChange(this, BR.favorite)
        }
}