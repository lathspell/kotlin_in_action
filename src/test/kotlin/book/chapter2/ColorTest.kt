package book.chapter2

import book.chapter2.Color.*
import book.chapter2.Color.Companion.getMnemonic
import book.chapter2.Color.Companion.getWarmth
import book.chapter2.Color.Companion.mix
import book.chapter2.Color.Companion.mixOptimized
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
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

    @Test
    fun testMixOptimized() {
        assertEquals(GREEN, mixOptimized(YELLOW, BLUE))
    }

    @Test(expected = Exception::class) // Java style
    fun testMixOptimizedError() {
        mixOptimized(YELLOW, YELLOW)
    }

    @Test
    fun testMixOptimizedErrorBetter() {
        assertFailsWith(Exception::class) {
            mixOptimized(YELLOW, YELLOW)
        }
    }
}