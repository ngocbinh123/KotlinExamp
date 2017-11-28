package com.dou.kotlinexam.ui.root

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.dou.kotlinexam.R
import com.dou.kotlinexam.base.BaseActivity
import com.dou.kotlinexam.model.Channel
import kotlinx.android.synthetic.main.activity_root.*

/**
 * Created by nnbinh on 11/27/17.
 */
class RootActivity : BaseActivity(), IRootContract.View {
    private lateinit var mPresenter: IRootContract.Presenter
    private lateinit var mAdapter: ChannelListAdapter
//    object name: Companion
    companion object {
        fun start(ctx: Context) {
            val intent = Intent(ctx, RootActivity::class.java) // java:  new Intent(ctx, RootActivity.class);
            ctx.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)
        setTitle(R.string.lbl_channel_list)

        mPresenter = RootPresenterImpl(this)
        mAdapter = ChannelListAdapter(null, mPresenter)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView.setItemViewCacheSize(20)
        recyclerView.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH
        recyclerView.isDrawingCacheEnabled= true
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mAdapter
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }

    override fun getScreenCtx(): Context = this

    override fun loadDataOnUI(channels: List<Channel>) {
        mAdapter.data = channels
    }

    override fun showMessage(message: String) {
        showMessageByToast(message)
    }

}