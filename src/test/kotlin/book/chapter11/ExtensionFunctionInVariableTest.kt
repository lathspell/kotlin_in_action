package book.chapter11

import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ExtensionFunctionInVariableTest {

    @Test
    fun test() {

        val meUpperCase: String.() -> String = {
            this.toUpperCase(Locale.GERMANY)
        }

        assertEquals("BOO", "boO".meUpperCase())
        assertEquals("BOO", meUpperCase("bOo"))
    }
}