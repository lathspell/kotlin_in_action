package book.chapter4

import kotlin.test.Test
import kotlin.test.assertEquals

/** Example Interface with one default and one abstract method. */
interface Machine4 {
    fun button(): String {
        // ... more stuff ...
        return "pressed"
    }

    fun lever(): String
}

/**
 * Example class implementing the above interface.
 *
 * Implemented methods must be marked with the `override` keyword.
 */
class ThatMachine : Machine4 {
    override fun lever(): String {
        return "lifted"
    }
}

class InterfaceTest {

    @Test
    fun test1() {
        val m = ThatMachine()
        assertEquals("pressed", m.button())
        assertEquals("lifted", m.lever())
    }
}