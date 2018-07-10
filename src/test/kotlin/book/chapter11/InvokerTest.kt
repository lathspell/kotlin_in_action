package book.chapter11

import kotlin.test.Test
import kotlin.test.assertEquals

class InvokerTest {

    @Test
    fun test1() {
        val foo = Foo("red")
        assertEquals("I am red", foo())
    }

    class Foo(val color: String) {
        operator fun invoke(): String {
            return "I am $color"
        }
    }
}