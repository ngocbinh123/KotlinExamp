package com.dou.kotlinexam.base.recyclerView

import android.support.v7.widget.RecyclerView

/**
 * Created by nnbinh on 11/29/17.
 */
abstract class BaseAdapter<T>(var _data: MutableList<T> = arrayListOf()) : RecyclerView.Adapter<BaseViewHolder<T>>() {
    constructor(_data: MutableList<T>, view: RecyclerView?) : this(_data)

    var data = _data
    set(value) {
        _data = value
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>?, position: Int) {
        holder?.bindItem(data[position], position)
    }

    override fun getItemCount(): Int  = data.size

    fun add(item: T) {
        data.add(item)
        notifyItemInserted(data.size - 1)
    }
}