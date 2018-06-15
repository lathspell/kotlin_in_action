package book.chapter6

import kotlin.test.Test
import kotlin.test.assertEquals

class MutableCollectionsTest {

    @Test
    fun testCollections() {
        val arrayList = arrayListOf(1, 2, 3)

        val roList = arrayList as List<Int>
        val rwList = arrayList as MutableList<Int>

        // does not exist: roList.remove(2) - read only interface
        rwList.remove(2) // - read write interface

        assertEquals(listOf(1, 3), arrayList)
        assertEquals(listOf(1, 3), roList)
        assertEquals(listOf(1, 3), rwList)
    }

}