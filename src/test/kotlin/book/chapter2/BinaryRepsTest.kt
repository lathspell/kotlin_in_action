package book.chapter2

import org.junit.Test
import kotlin.test.assertEquals

class BinaryRepsTest {
    @Test
    fun test2() {
        assertEquals("1000001 1000010 1000010 1000001", toBinaryString("ABBA"))
    }
}