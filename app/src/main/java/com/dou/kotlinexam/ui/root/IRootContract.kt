package com.dou.kotlinexam.ui.root

import com.dou.kotlinexam.base.ILifeCycle
import com.dou.kotlinexam.database.model.Channel

/**
 * Created by nnbinh on 11/27/17.
 */
interface IRootContract {
    interface View: ILifeCycle.View {
        fun loadDataOnUI(channels: List<Channel>)
    }

    interface Presenter: ILifeCycle.Presenter {
        var mView: IRootContract.View? // abstract
        fun getDataFromApi()
        fun changeItemState(item: Channel)
    }
}