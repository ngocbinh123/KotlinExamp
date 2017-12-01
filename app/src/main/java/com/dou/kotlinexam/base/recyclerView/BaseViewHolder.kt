package com.dou.kotlinexam.base.recyclerView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by nnbinh on 11/29/17.
 */
abstract class BaseViewHolder<T>(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    private var mPosition = 0
    private var mItem: T? = null
    constructor(parent: ViewGroup,layoutId:Int) : this(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false))

    abstract fun onBindItem(item:T, position:Int)
    interface OnClickListener<in T> {
        fun onClickItem(item:T?, position:Int)
    }
    fun bindItem(item:T, position: Int) {
        mItem = item
        mPosition = position
        onBindItem(item, position)
    }

    fun setOnClickListener(listener: OnClickListener<T>) {
        itemView.setOnClickListener{listener.onClickItem(mItem, mPosition)}
    }
}