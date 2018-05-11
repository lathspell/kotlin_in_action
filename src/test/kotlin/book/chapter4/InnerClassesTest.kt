package book.chapter4

import kotlin.test.Test
import kotlin.test.assertEquals

class Outer {
    class Inner1 {
        fun greeting(): String {
            return "Static inner class, no access to instance members of 'Outer'!"
        }
    }

    inner class Inner2 {
        fun greeting(): String {
            return this@Outer.greeting()
        }
    }

    private fun greeting(): String = "Hello"
}

class InnerClassesTest {
    @Test
    fun test1() {
        // It needs an instance of "Outer" to be able to instantiate the non-static inner class "Inner2"
        assertEquals("Hello", Outer().Inner2().greeting())
    }
}