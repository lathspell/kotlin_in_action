package book.chapter11

import kotlin.test.Test
import kotlin.test.assertEquals

class ExtensionOnPrimitivesTest {

    private fun Int.halfOfIt() = this / 2

    @Test
    fun test1() {
        assertEquals(21, 42.halfOfIt())
    }
}