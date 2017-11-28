package com.dou.kotlinexam.base

import android.content.Context

/**
 * Created by nnbinh on 11/27/17.
 */
interface ILifeCycle {
    interface View {
        fun getScreenCtx(): Context
        fun showMessage(message: String)
    }

    interface Presenter {
        fun onResume()
        fun onDestroy()
    }
}