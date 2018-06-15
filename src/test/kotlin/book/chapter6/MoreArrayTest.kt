package book.chapter6

import kotlin.test.Test
import kotlin.test.assertEquals

class MoreArrayTest {

    // Create an array using a specific size with an initialization method.
    @Test
    fun createArrayOfLetters() {
        val letters = Array<String>(6) { i -> ('A' + i).toString() }
        assertEquals("ABCDEF", letters.joinToString(""))
    }

    // Pass the contents of an array when multiple arguments are expected using the "spread operator".
    // Does only work with arrays, not other collection types.
    @Test
    fun spreadButter() {
        val letters = arrayOf("b", "t", "r")
        val actual = String.format("%s%s%s", *letters)
        assertEquals("btr", actual)

    }
}