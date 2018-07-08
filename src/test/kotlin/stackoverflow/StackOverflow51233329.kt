package stackoverflow

import kotlin.test.Test
import kotlin.test.assertEquals

class StackOverflow51233329 {

    @Test
    fun test() {
        var letter = 'A'

        lateinit var example: () -> Char

        example = {
            letter++
            if (letter >= 'C') letter else example()
        }

        assertEquals('C', example())
    }
}