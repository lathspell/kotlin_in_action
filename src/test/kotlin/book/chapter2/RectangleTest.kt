import book.chapter2.Rectangle
import book.chapter2.createRandomRectangle
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RectangleTest {
    @Test
    fun test1() {
        val r1 = createRandomRectangle()
        assertTrue { r1.isSquare == r1.isSquare2 }
        assertEquals(r1.isSquare, (r1.width == r1.height))

        val r2 = Rectangle(1, 4)
        assertFalse(r2.isSquare)

        val r3 = Rectangle(3, 3)
        assertTrue { r3.isSquare2 }
    }
}