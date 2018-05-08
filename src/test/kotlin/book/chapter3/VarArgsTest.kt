package book.chapter3

import org.junit.Test
import kotlin.test.assertEquals

class VarArgsTest {

    private fun addThem(vararg values: Int): Int {
        return values.map { it * 2 }.sum()
    }

    @Test
    fun test1() {
        assertEquals(20, addThem(1, 2, 3, 4))
    }
}