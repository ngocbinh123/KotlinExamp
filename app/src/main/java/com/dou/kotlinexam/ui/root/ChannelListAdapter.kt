package com.dou.kotlinexam.ui.root

import android.databinding.DataBindingUtil
import android.view.ViewGroup
import com.dou.kotlinexam.R
import com.dou.kotlinexam.base.BaseRecyclerAdapter
import com.dou.kotlinexam.base.BaseRecyclerViewHolder
import com.dou.kotlinexam.databinding.LayoutChannelItemBinding
import com.dou.kotlinexam.model.Channel

/**
 * Created by nnbinh on 11/27/17.
 */
class ChannelListAdapter(data: MutableList<Channel>?, val mPresenter:IRootContract.Presenter) : BaseRecyclerAdapter<Channel>(data) {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseRecyclerViewHolder<Channel> {
        return  ViewHolder(parent)
    }

    inner class ViewHolder (parent: ViewGroup?, layoutId: Int =  R.layout.layout_channel_item) : BaseRecyclerViewHolder<Channel>(parent, layoutId) {
        val mBind: LayoutChannelItemBinding =  DataBindingUtil.bind(view)
        override fun onBindItem(item: Channel?, position: Int) {
            mBind.item = item
            mBind.presenter = mPresenter
        }
    }
}