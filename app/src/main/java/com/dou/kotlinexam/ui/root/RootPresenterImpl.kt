package com.dou.kotlinexam.ui.root

import com.dou.kotlinexam.model.Channel
import com.dou.kotlinexam.webApi.ApiManager
import com.dou.kotlinexam.webApi.ILoadItemCallback

/**
 * Created by nnbinh on 11/27/17.
 */
class RootPresenterImpl(override var mView: IRootContract.View?) : IRootContract.Presenter {
    val mApiManager by lazy {
        ApiManager.get()
    }

    override fun getDataFromApi() {
        mApiManager.getChannelList(object : ILoadItemCallback<List<Channel>> {
            override fun onLoadedItem(item: List<Channel>) {
                mView?.loadDataOnUI(item)
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
    }
}