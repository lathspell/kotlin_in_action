package book.chapter4

import kotlin.test.Test
import kotlin.test.assertEquals

class AdvancedConstructorTest {
    class AC1(val lastName: String, val firstName: String, val nationality: String = "unknown")

    @Test
    fun testParameterNames() {
        // parameter names can explicitly specified to change their order
        // "nationality" was not specified and did not need to as it has a default value
        assertEquals("Max", AC1(firstName = "Max", lastName = "Müller").firstName)
    }
}