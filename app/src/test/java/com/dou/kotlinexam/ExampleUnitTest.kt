package com.dou.kotlinexam

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun checkArray() {
        val arr:MutableList<String> = arrayListOf("","","")
        arr.add("EN")
        arr.add("FR")
        arr.add("SIN")
        arr.add("JP")
        arr.add("KR")


//        Creates an Array<String> with values ["0", "1", "4", "9", "16"]
        val ls = Array(5, {i-> (i*i).toString()})



        assertTrue(String.format("array is empty", arr.size > 0), arr.size > 0)
//        assertTrue(String.format("%s is null or empty.", word), !word.isNullOrEmpty())


        // init parent list
        val parentList = arrayListOf("hello", "hi", "everybody", "good morning", "good afternoon", "good evening")

        // add item into list
        parentList.add("design pattern")
        parentList.add(0, "the first item")
        parentList.add(3, "the middle item")

        // add sub list into parent list
        val subList = arrayListOf("declare", "architecture", "kotlin", "java")
        parentList.addAll(subList)

    }

    @Test
    fun checkIsNullOrEmpty() {
        var word: String? = null

        assertTrue(String.format("%s is null or empty.", word), !(word != null && word != ""))
//        assertTrue(String.format("%s is null or empty.", word), !word.isNullOrEmpty())
    }

    @Test
    fun checkPalindrome() {
        val numb = 2
        val isPalindrome = isPalindrome(numb)
        assertTrue(String.format("%d isn\'t prime number.", numb), isPalindrome)
    }

    /**
     * check number input is palindrome
     * @param  numb: number
     * */
    fun isPalindrome(numb: Int): Boolean {
        if (numb == 2)
            return true

        var isPrime = numb > 1
        if (!isPrime)
            return false

        val n = numb/2 + 1
        for (i in 2..n) {
            if (numb % i == 0) {
                isPrime = false
                break
            }
        }

        (2..n).filter { numb % it == 0}.map {
            isPrime = false
        }

        isEvenNumber(12)
        return isPrime
    }

    fun isEvenNumber(numb: Int): Boolean {
        if (numb % 2 == 0) {
            return true
        }
        return false
    }

    @Test
    fun checkMonth() {
        (1..12 step 2).last == 11
    }

    fun getMonthName(month: Int): String? {
        var result: String? = when(month) {
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
        return result
    }
}
