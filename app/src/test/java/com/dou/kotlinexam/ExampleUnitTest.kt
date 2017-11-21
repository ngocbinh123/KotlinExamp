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
//            for (i in 2..n) {
//                if (numb % i == 0) {
//                    isPrime = false
//                    break
//                }
//            }

        (2..n).filter { numb % it == 0}.map {
            isPrime = false
        }
        return isPrime
    }
}
