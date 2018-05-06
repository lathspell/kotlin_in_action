package book.chapter2

import book.chapter2.Color2
import org.junit.Test
import kotlin.test.assertEquals

class Color2Test {
    @Test
    fun test() {
        assertEquals(238, Color2.VIOLET.r)
        assertEquals(15631086, Color2.VIOLET.rgb())
    }
}