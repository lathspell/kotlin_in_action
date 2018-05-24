package book.chapter6

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class NullTest {

    class Town(val name: String, val zip: Int)
    class Address(val street: String, val town: Town)
    class Employee(val name: String, val addr: Address)
    class Freelancer(val name: String, val addr: Address?)

    private val tom = Employee("Tom", Address("FooStreet", Town("FooTown", 12345)))
    private val freddy = Freelancer("Freddy", null)

    @Test
    fun testNulls() {
        // NPEs cannot happen as all variables in the chain are non-null
        val tomsZip = tom.addr.town.zip
        assertEquals(12345, tomsZip)

        // There could be a NULL value in Freelander.addr so everything after it is "tainted"
        val freddysZip = freddy.addr?.town?.zip
        assertNull(freddysZip)

        // Default value using the Elvis operator
        val freddysDefault = freddy.addr?.town?.zip ?: "00000"
        assertEquals("00000", freddysDefault)
    }

    @Test(expected = NullPointerException::class)
    fun testNpe() {
        val freddysZip = freddy.addr!!.town.zip
        assertNotNull(freddysZip) // never reached
    }

    @Test
    fun testSafeCasts() {
        val myInt = "one" as? Int
        assertNull(myInt) // it's NULL due to the "as?" operator. Shorter than catching the Exception.
    }

    // "let" executes a code block on a variable if it is not NULL
    @Test
    fun testLet() {
        var theZip = 99999

        freddy.addr?.let { theZip = it.town.zip }
        assertEquals(99999, theZip)

        tom.addr.let { theZip = it.town.zip }
        assertEquals(12345, theZip)
    }
}