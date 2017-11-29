package com.dou.kotlinexam.database

import com.dou.kotlinexam.database.model.Channel
import com.dou.kotlinexam.database.model.Channel_Table
import com.raizlabs.android.dbflow.annotation.Database
import com.raizlabs.android.dbflow.config.FlowManager
import com.raizlabs.android.dbflow.sql.language.Select

/**
 * Created by nnbinh on 11/28/17.
 */
@Database(name = AppDatabase.NAME, version =  AppDatabase.VER)
object AppDatabase {
    const val NAME = "AppDatabase"
    const val VER = 1

    fun getChannelList(): MutableList<Channel> = Select().from(Channel::class.java).queryList()
    fun getChannel(id:Int): Channel? = Select().from(Channel::class.java).where(Channel_Table.id.`is`(id)).querySingle()
    fun saveChannelList(ls: List<com.dou.kotlinexam.database.model.Channel>) {
        FlowManager.getDatabase(AppDatabase::class.java).transactionManager.saveQueue.addAll(ls)
    }
}