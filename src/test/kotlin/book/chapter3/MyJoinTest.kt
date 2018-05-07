package book.chapter3

import kotlin.test.Test
import kotlin.test.assertEquals

class MyJoinTest {
    @Test
    fun test1() {
        assertEquals("a, b, c", myJoin(listOf("a", "b", "c"), ", ", "", ""))
        assertEquals("a, b, c", myJoin(listOf("a", "b", "c")))
        assertEquals("a|b|c", myJoin(listOf("a", "b", "c"), "|"))
        assertEquals("a, b, c", theirJoin(listOf("a", "b", "c"), ", ", "", ""))

        // with named operators
        assertEquals("a, b, c", myJoin(elements = listOf("a", "b", "c"), separator = ", ", prefix = "", postfix = ""))
    }

    @Test
    fun testJoinWith() {
        // testing my own infix function
        assertEquals("a, b, c", listOf("a", "b", "c") joinWith ", ")
    }
}