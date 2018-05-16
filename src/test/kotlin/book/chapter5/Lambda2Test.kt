package book.chapter5

import kotlin.test.Test
import kotlin.test.assertEquals

class Lambda2Test {

    @Test
    fun test() {
        val f = { x: Int -> 2 * x } // function that maps an Int to an Int of double its value
        val y = f(3)
        assertEquals(6, y)

        val f2 = { x: Int -> "#$x" } // function that maps an Int to a similar looking String
        val y2 = f2(4)
        assertEquals("#4", y2)
    }

    @Test
    fun testLambdaAsNamedParameter() {
        val actual = listOf("a", "bbb", "cc").joinToString(separator = ";", transform = { it.toUpperCase() })
        assertEquals("A;BBB;CC", actual)
    }
}