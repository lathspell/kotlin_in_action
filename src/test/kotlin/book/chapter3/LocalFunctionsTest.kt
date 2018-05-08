package book.chapter3

import org.junit.Test
import kotlin.test.assertEquals

class LocalFunctionsTest {

    /** Method-local functions are possible. */
    @Test
    fun test1() {
        fun foo(): Int = 42

        assertEquals(42, foo())
    }
}