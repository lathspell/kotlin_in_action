package book.chapter2

import kotlin.test.Test
import kotlin.test.assertEquals

class ExceptionTest {
    @Test
    fun test1() {
        assertEquals("E", tryDivision(3, 0))
        assertEquals("1", tryDivision(3, 2))
    }

    private fun tryDivision(a: Int, b: Int): String =
            try {
                (a / b).toString() // no "return" in expressions!
            } catch (e: Exception) {
                "E"  // no "return" in expressions!
            } finally {
                // also possible
            }
}