package book.chapter3.sub

import kotlin.test.Test
import kotlin.test.assertEquals
import book.chapter3.joinWith as joinWithSeparator

/**
 * Import of extension functions.
 *
 * Extension functions like my "joinWith" are not automatically globally available.
 * Instead they must be imported if not in the same package.
 * While importing they can be aliased.
 */
class MyJoinFromDifferentPackageTest {
    @Test
    fun test1() {
        assertEquals("1,2,3", listOf(1, 2, 3) joinWithSeparator ",")
    }
}