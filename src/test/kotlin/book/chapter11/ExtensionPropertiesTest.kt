package book.chapter11

import java.time.LocalDate
import java.time.Period
import kotlin.test.Test
import kotlin.test.assertEquals

/** Testing weired DSL examples. */
class ExtensionPropertiesOnDate {

    // This ain't an "extension function" but an "extension property"!
    private val Int.days: Period
        get() = Period.ofDays(this)

    // Now we continue with creating an extension function on Period
    private fun Period.before(dateStr: String) = LocalDate.parse(dateStr).minus(this).toString()

    @Test
    fun test() {
        assertEquals(Period.ofDays(3), 3.days)
        assertEquals("2018-04-02", 3.days.before("2018-04-05"))
    }
}