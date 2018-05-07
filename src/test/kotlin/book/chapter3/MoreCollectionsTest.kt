package book.chapter3

import kotlin.test.Test
import kotlin.test.assertEquals

class MoreCollectionsTest {
    @Test
    fun test1() {
        // "to" is not a language construct but an infix operator that generates a Pair(a, b)
        val map = hashMapOf("a" to 1, "b" to 2, "c" to 3)
        assertEquals(2, map["b"])

        val map2 = hashMapOf(Pair("a", 1), Pair("b", 2), Pair("c", 3))
        assertEquals(2, map2["b"])

        // The data structures are no Kotlin specific classes but regular Java Collections
        assertEquals("java.util.HashMap", map.javaClass.canonicalName)

        assertEquals("a", map.keys.first())
        assertEquals(3, map.values.max())
    }
}