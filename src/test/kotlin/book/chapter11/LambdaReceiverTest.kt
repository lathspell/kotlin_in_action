package book.chapter11

import kotlin.test.Test
import kotlin.test.assertEquals

class LambdaReceiverTest {
    // `f` is a lambda function that does something with a StringBuilder argument
    private fun buildString1(f: (StringBuilder) -> Unit): String {
        val sb = StringBuilder()
        f(sb)
        return sb.toString()
    }

    // `f` is now a "Lambda with a Receiver", written like an "extension function" to the StringBuilder class
    private fun buildString2(f: StringBuilder.() -> Unit): String {
        val sb = StringBuilder()
        f(sb)
        return sb.toString()
    }

    // In Kotlin `apply()` can be used to build function chains
    private fun buildString3(f: StringBuilder.() -> Unit): String = StringBuilder().apply(f).toString()

    @Test
    fun lambda1() {
        val actual = buildString1(
                fun(sb: StringBuilder) {
                    sb.append("1")
                    sb.append("2")
                })
        assertEquals("12", actual)
    }

    @Test
    fun lambda1b() {
        val actual = buildString1 {
            it.append("1")
            it.append("2")
        }
        assertEquals("12", actual)
    }

    @Test
    fun lambda2WithReceiver() {
        val actual = buildString2 {
            append("1")
            append("2")
        }
        assertEquals("12", actual)
    }

    @Test
    fun lambda3WithReceiverAndApply() {
        val actual = buildString3 {
            append("1")
            append("2")
        }
        assertEquals("12", actual)
    }
}
