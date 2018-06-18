package book.chapter7

import book.chapter7.mydate.Mydate
import book.chapter7.mydate.MydateProgression
import java.util.*
import kotlin.test.*

/**
 * Operator Overloading.
 *
 * Unary operators:
 *  - unaryMinus
 *
 * Binary operators:
 *  + plus
 *  - minus
 *  / div
 *  % mod
 *  * times
 *
 * bitwise operators:
 *  shl
 *  shr
 *  ushr
 *  and
 *  or
 *  xor
 *  inv
 *
 * compound assignment operators:
 *  += plusAssign
 *  -= minusAssign
 *
 * - remember that "a + b" is rewritten as "a.plus(b)".
 * - not all operators can be used with immutable data types (e.g. "++x" or "+=")
 */
class OverloadingTest {

    private val p1 = Point(10, 20)
    private val p2 = Point(30, 40)
    private val m1 = MutablePoint(10, 20)


    @Test
    fun testPlus() = assertEquals(Point(40, 60), p1 + p2)

    @Test
    fun testMinus() = assertEquals(Point(-20, -20), p1 - p2)

    @Test
    fun testCompountAssign() {
        val tmp = p1
        tmp += Point(5, 0)
        assertEquals(Point(15, 20), tmp)
    }

    @Test
    fun testUnaryMinus() = assertEquals(Point(-10, -20), -p1)

    @Test
    fun testIncrease() {
        var tmp = p1
        tmp++
        assertEquals(Point(11, 21), tmp)
    }

    @Test
    fun testEquality() {
        val pp1 = Point(10, 20)
        assertEquals(p1, pp1)
        assertNotEquals(p1, p2)
    }

    @Test
    fun testArrayGet() = assertEquals(20, m1['Y'])

    @Test
    fun testArraySet() {
        val tmp = MutablePoint(10, 30)
        tmp['X'] = 11
        assertEquals(MutablePoint(11, 30), tmp)
    }

    @Test
    fun testContains() {
        val rect = Rectangle(Point(10, 10), Point(20, 100))
        assertTrue(Point(11, 50) in rect)
        assertFalse(Point(9, 50) in rect)
    }

    @Test
    fun testRanges() {
        val dates = Mydate(10)..Mydate(15)
        val date = Mydate(12)
        assertTrue(dates is ClosedRange)
        assertTrue(date in dates)
    }

    @Test
    fun testIterator() {
        val list = TreeSet<Int>()
        for (i in 1..6 step 2) {
            list.add(i)
        }
        assertEquals(setOf(1, 3, 5), list)

        val from: Int = 1
        val fromRange: IntRange = from.rangeTo(6) // IntRange implements IntProgression with step 1
        val fromProg: IntProgression = fromRange.step(2) // IntProgression implements Iterable
        list.clear()
        for (i in fromProg) {
            list.add(i)
        }
        assertEquals(setOf(1, 3, 5), list)
    }

    @Test
    fun testCustomIterator() {
        val list = TreeSet<Mydate>()
        for (i in MydateProgression(10, 15, 2)) {
            list.add(i)
        }
        assertEquals(setOf(Mydate(10), Mydate(12), Mydate(14)), list)

        assertEquals(setOf(Mydate(1), Mydate(4)), MydateProgression(1, 5, 3).toSet())
        assertEquals(setOf(Mydate(1), Mydate(4), Mydate(7)), MydateProgression(1, 7, 3).toSet())
    }
}