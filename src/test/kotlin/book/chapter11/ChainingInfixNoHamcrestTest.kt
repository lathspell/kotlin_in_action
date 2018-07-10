package book.chapter11

import book.chapter11.ChainingInfixNoHamcrestTest.StringMatchers.Companion.startWith
import kotlin.test.Test

class ChainingInfixNoHamcrestTest {

    @Test
    fun test1() {
        "Foo" must startWith("F")

        // same as:
        StringMatchers.startWith("F").test("Foo")
    }

    @Test(expected = AssertionError::class)
    fun test2() {
        "Foo" must startWith("B")
    }

    private infix fun <T> T.must(b: Matcher<T>) = b.test(this)

    class Matcher<T>(private val testFunc: (a: T) -> Boolean) {
        fun test(that: T) = if (!testFunc(that)) throw AssertionError("failed") else Unit
    }

    class StringMatchers {
        companion object {
            @JvmStatic
            fun startWith(b: String) = Matcher<String>(fun(a) = a.startsWith(b))
        }
    }
}