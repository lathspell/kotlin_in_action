package book.chapter5

import kotlin.test.Test
import kotlin.test.assertEquals

class WithAndApplyTest {

    @Test
    fun testClassicJava() {
        val result = StringBuilder()

        for (letter in 'A'..'F') {
            result.append(letter)
        }

        assertEquals("ABCDEF", result.toString())
    }

    @Test
    fun testKotlinWith() {
        val result = StringBuilder()

        // with() is a function that takes a variable (here "result") and applies a code block to it
        with(result) {
            for (letter in 'A'..'F') {
                append(letter) // same as "this.append()"
            }
        }

        assertEquals("ABCDEF", result.toString())
    }

    @Test
    fun testKotlinWithAsFunction() {
        val result = StringBuilder()

        with(receiver = result, block = {
            for (letter in 'A'..'F') append(letter)
        })

        assertEquals("ABCDEF", result.toString())
    }

    @Test
    fun testKotlinWithAsFunction2() {
        val result = StringBuilder()

        val appendAF = fun(sb: StringBuilder) {
            for (letter in 'A'..'F') sb.append(letter)
        }

        with(receiver = result, block = appendAF)

        assertEquals("ABCDEF", result.toString())
    }

    /** buildString() is a nice Kotlin standard library method to build strings using StringBuilder and with(). */
    @Test
    fun testBuildString() {
        val result = buildString {
            for (letter in 'A'..'F') append(letter)
            append("!")
        }
        assertEquals("ABCDEF!", result.toString())
    }

    @Test
    fun testApply() {
        val result = StringBuilder().apply {
            for (letter in 'A'..'F') append(letter)
        }.toString()
        assertEquals("ABCDEF", result)
    }
}