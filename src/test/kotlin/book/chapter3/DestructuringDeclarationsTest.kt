package book.chapter3

import kotlin.test.Test
import kotlin.test.assertEquals

class DestructuringDeclarationsTest {
    data class MyResult(val code: Int, val msg: String)

    @Test
    fun testDataClass() {
        val (code, msg) = MyResult(32, "Foo")
        assertEquals(32, code)
        assertEquals("Foo", msg)

        // the convention functions
        val result = MyResult(32, "Foo")
        assertEquals(32, result.component1())
        assertEquals("Foo", result.component2())
    }

    @Test
    fun testMap() {
        val myMap = hashMapOf("a" to 1, "b" to 2)

        // Iterating over the Map.Entry elements of a map.
        // "_" marks an unused component to avoid compiler warnings for unused variables
        var sum = 0
        for ((_, value) in myMap) {
            sum += value
        }

        assertEquals(3, sum)
    }
}