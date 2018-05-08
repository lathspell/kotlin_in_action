package book.chapter3

import org.junit.Test
import kotlin.test.assertTrue

class RegexTest {

    /** Triple-quoted strings are not escaped by Kotlin thus \. is really the regex for a literal dot. */
    @Test
    fun testTripleQuotedString() {
        val input = "0.4"
        assertTrue(input.matches("""0\.""".toRegex()))
    }
}