package book.chapter3

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class DestructuringDeclarationsTest {
    data class MyResult(val code: Int, val msg: String)

    @Test
    fun testDataClass() {
        val (code, msg) = MyResult(32, "Foo")
        assertEquals(32, code)
        assertEquals("Foo", msg)
    }

    @Test
    fun testMap() {
        val myMap = hashMapOf("a" to 1, "b" to 2)
        var sum = 0
        for ((key, value) in myMap) {
            assertNotNull(key)
            sum += value
        }
        assertEquals(3, sum)
    }
}