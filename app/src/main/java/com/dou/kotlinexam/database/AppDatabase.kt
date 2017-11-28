package com.dou.kotlinexam.database

import com.raizlabs.android.dbflow.annotation.Database
import com.raizlabs.android.dbflow.sql.language.Select
import java.nio.channels.Channel

/**
 * Created by nnbinh on 11/28/17.
 */
@Database(name = AppDatabase.NAME, version =  AppDatabase.VER)
object AppDatabase {
    const val NAME = "AppDatabase"
    const val VER = 1

    fun getChannelList(): MutableList<Channel> = Select().from(Channel::class.java).queryList()
}