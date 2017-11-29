package com.dou.kotlinexam.ui.root

import android.util.Log
import com.dou.kotlinexam.database.AppDatabase
import com.dou.kotlinexam.database.model.Channel
import com.dou.kotlinexam.webApi.ApiManager
import com.dou.kotlinexam.webApi.ILoadItemCallback
import io.reactivex.rxkotlin.toObservable

/**
 * Created by nnbinh on 11/27/17.
 */
class RootPresenterImpl(override var mView: IRootContract.View?) : IRootContract.Presenter {
    private val TAG = RootPresenterImpl::class.java.canonicalName
    private val mApiManager by lazy {
        ApiManager.get()
    }

    override fun getDataFromApi() {
        mApiManager.getChannelList(object : ILoadItemCallback<List<Channel>> {
            override fun onLoadedItem(item: List<Channel>) {
                item.toObservable().subscribe(
                        {
                            val localItem = AppDatabase.getChannel(it.id)
                            if (localItem != null && localItem.isFavorite)
                                it.isFavorite = true
                            it.save()
                            mView?.addMore(it)
                            Log.d(TAG, "===> ${it.id} ${it.title}")
                        },
                        {err -> mView?.showMessage(err.message!!)}
                )
            }

            override fun onLoadedFailed(error: String) {
                mView?.showMessage(error)
            }
        })
    }

    override fun onDestroy() {
        mView = null
    }

    override fun onResume() {
        getDataFromApi()
    }

    override fun changeItemState(item: Channel) {
        item.isFavorite = !item.isFavorite
        item.save()
    }
}