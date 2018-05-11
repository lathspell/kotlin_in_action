package book.chapter4

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * An example of a sealed class.
 *
 * Sealed does not mean "closed" or otherwise prevent instantiation. Rather it's like a hint to the
 * compiler to remember all subclasses of this (implicitly abstract) class in case it is used in an
 * expression `when`. There the default case can be omitted as the compiler can check if all other
 * cases where explicitly specified.
 */
sealed class RgbColor(private val me: String) {
    fun color(): String = me
}

class RgbRed : RgbColor("red")

class RgbGreen : RgbColor("green")

class RgbBlue : RgbColor("blue")

class SealedClassTest {
    @Test
    fun test1() {
        val color: RgbColor = RgbGreen()
        val colorName = when (color) {
            is RgbRed -> "Red is " + color.color()
            is RgbGreen -> "Green is " + color.color()
            is RgbBlue -> "Blue is " + color.color()
        // no `else` as the compiler knows all possible subclasses of a `sealed class`
        }
        assertEquals("Green is green", colorName)
    }
}