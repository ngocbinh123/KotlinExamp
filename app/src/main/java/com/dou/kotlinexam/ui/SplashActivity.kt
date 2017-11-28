package com.dou.kotlinexam.ui

import android.os.Bundle
import com.dou.kotlinexam.R
import com.dou.kotlinexam.base.BaseActivity
import com.dou.kotlinexam.ui.login.LoginActivity
import com.dou.kotlinexam.ui.root.RootActivity

/**
 * Created by nnbinh on 11/24/17.
 */
class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.decorView.postDelayed({
            val isLogon: Boolean = getDataBySharePref(LoginActivity.KEY_EMAIL).isNullOrEmpty()
            if (isLogon)
                LoginActivity.start(this)
            else
                RootActivity.start(this)
        }, 1800)
    }
}