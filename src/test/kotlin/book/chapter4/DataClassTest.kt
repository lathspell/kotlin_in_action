package book.chapter4

import kotlin.test.Test
import kotlin.test.assertEquals

class DataClassTest {

    data class MyData(val firstName: String, val lastName: String)

    @Test
    fun test() {
        val d1 = MyData("Max", "Manderisk")
        val d2 = d1.copy(lastName = "Mursk") // implicitly generated method for "data" classes
        assertEquals("Max", d2.firstName) // cloned
        assertEquals("Mursk", d2.lastName) // due to constructor argument to ".clone()"
    }
}
