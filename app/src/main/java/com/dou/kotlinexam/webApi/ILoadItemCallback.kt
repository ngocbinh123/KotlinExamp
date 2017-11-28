package com.dou.kotlinexam.webApi

/**
 * Created by nnbinh on 11/27/17.
 */
interface ILoadItemCallback<T> {
    /**
     * load item is complete.
     */
    fun onLoadedItem(item: T)

    /**
     * loading this item is error.
     */
    fun onLoadedFailed(error: String)
}