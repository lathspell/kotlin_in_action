package book.chapter6

import kotlin.test.Test
import kotlin.test.assertTrue

class UnitTest {

    // The return type " : Unit" is implicitly assumed if omitted
    private fun blackhole(i: Int) {
        if (i == 1) print("")
    }

    @Test
    fun testUnit() {
        // Unlike "void" in Java, Unit is no language construct but a regular Kotlin object (singleton).
        // It's therefore possible to compare against it
        assertTrue(blackhole(42) == Unit)
    }

}