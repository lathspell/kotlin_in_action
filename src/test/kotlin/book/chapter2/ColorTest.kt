package book.chapter2

import book.chapter1.Person
import book.chapter2.Color
import book.chapter2.Color.*
import book.chapter2.Color.Companion.getMnemonic
import book.chapter2.Color.Companion.getWarmth
import book.chapter2.Color.Companion.mix
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals


class ColorTest {

    @Test
    fun testRainbow() {
        Color.values()
        assertEquals("York", getMnemonic(YELLOW))
        assertNotEquals("York", getMnemonic(ORANGE))
    }

    @Test
    fun testWarmth() {
        assertEquals("neutral", getWarmth(GREEN))
    }

    @Test
    fun testMix() {
        assertEquals(GREEN, mix(YELLOW, BLUE))
    }
}