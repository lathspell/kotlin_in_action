package book.chapter9

import kotlin.test.Test
import kotlin.test.assertEquals

class GenericsTest {
    @Test
    fun test1() {
        fun <T> countThem(list: List<T>): Int = list.count()

        assertEquals(3, countThem(listOf(1, 2, 3)))
    }
}