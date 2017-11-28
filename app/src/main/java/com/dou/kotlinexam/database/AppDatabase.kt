package com.dou.kotlinexam.database

import com.raizlabs.android.dbflow.annotation.Database

/**
 * Created by nnbinh on 11/28/17.
 */
@Database(name = AppDatabase.NAME, version =  AppDatabase.VER)
class AppDatabase {
    companion object {
        const val NAME = "AppDatabase"
        const val VER = 1
    }
}