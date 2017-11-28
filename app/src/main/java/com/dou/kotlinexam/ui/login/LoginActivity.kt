package com.dou.kotlinexam.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.dou.kotlinexam.R
import com.dou.kotlinexam.base.BaseActivity
import com.dou.kotlinexam.ui.root.RootActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by nnbinh on 11/24/17.
 */
class LoginActivity : BaseActivity() {
    companion object {
        val KEY_EMAIL = "KEY_EMAIL"
        fun start(ctx: Context) {
            val intent = Intent(ctx, LoginActivity::class.java) // java:  new Intent(ctx, RootActivity.class);
            ctx.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener { startMainScreen() }
    }

    private fun startMainScreen() {
        saveDataBySharePref(KEY_EMAIL,  txtEmail.text.toString())
        RootActivity.start(this)
    }
}