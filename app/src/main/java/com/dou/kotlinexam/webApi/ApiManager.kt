package com.dou.kotlinexam.webApi

import com.dou.kotlinexam.model.Channel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by nnbinh on 11/27/17.
 */
class ApiManager {
    companion object {
        fun get(): ApiManager = ApiManager()
    }

    val mService = APIService.create()

    fun getChannelList(callback: ILoadItemCallback<List<Channel>>) {
        mService.getChannelList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {result -> callback?.onLoadedItem(result.channels)},
                        {err-> callback?.onLoadedFailed(err.message!!)}
                )
    }
}