package book.chapter2

import org.junit.Test
import kotlin.test.assertEquals

class FizzBuzzTest {

    @Test
    fun test1() {
        assertEquals("1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz", fizzbuzz(1..15))
    }

    @Test
    fun test2() {
        assertEquals("buzz, 8, fizz, 4, 2", fizzbuzz((10 downTo 1 step 2)))
    }
}