package com.dou.kotlinexam

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getMonthName(month: Int): String {
        return when(month) {
            1 -> "JANUARY"
            2 -> "FEBRUARY"
            3 -> "MARCH"
            4 -> "APR"
            5 -> "MAY"
            6 -> "JUNE"
            7 -> "JULY"
            8 -> "AUGUST"
            9 -> "SEPTEMBER"
            10 -> "OCTOBER"
            11 -> "NOVEMBER"
            12 -> "DECEMBER"
            else -> "$month isn't month"
        }
    }

    fun getQuarter(month: Int): String {
        return when(month) {
            in 1..3 -> "1st quarter"
            in 4..6 -> "2nd quarter"
            in 7..9 -> "3rd quarter"
            in 10..12 -> "4th quarter"
            else -> "$month isn't month"
        }
    }

    fun checkEvenNumber(numb: Int): String {
        return when {
            numb % 2 == 0 -> "$numb is even number"
            else -> "$numb is odd number"
        }
    }
}
