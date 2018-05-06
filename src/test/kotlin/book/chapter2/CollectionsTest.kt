package book.chapter2

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CollectionsTest {
    @Test
    fun testMapToList() {
        val mymap = mapOf(Pair(1, "A"), Pair(2, "B"), Pair(3, "C"))
        assertEquals("{1=A, 2=B, 3=C}", mymap.toString())

        val mylist = mymap.map { entry -> "" + entry.key + "=" + entry.value }
        assertEquals("[1=A, 2=B, 3=C]", mylist.toString())

        assertEquals("1=A, 2=B, 3=C", mylist.joinToString(", "))
    }

    @Test
    fun testIn() {
        assertTrue(4 in 0..9)
        assertFalse(4 in 10..19)
    }

    @Test
    fun testRecognize() {
        assertEquals("ccddx", Recognize.recognize("Fr03@"))
    }
}