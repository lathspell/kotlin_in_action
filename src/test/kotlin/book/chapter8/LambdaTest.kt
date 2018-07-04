package book.chapter8

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class LambdaTest {
    @Test
    fun test1() {
        val sum = { a: Int, b: Int -> a + b }

        var total = 0
        for (i in 0..2) {
            for (ii in 3..4) {
                total += sum(i, ii)
            }
        }
        assertEquals(27, total)
    }

    @Test
    fun testNullable() {
        // The following variable is not NULL - it is unusable until initialized!
        val canReturnNullUninitialized: (a: Int, b: Int) -> Int?

        // The following variable must be initialized but with a lambda function that itself may return NULL
        val canReturnNull: (a: Int, b: Int) -> Int? = { a, b -> null }
        assertNull(canReturnNull(1, 2))

        // The following variable can itself be NULL i.e. without a lambda function assigned at all
        val canBeNull: ((a: Int, b: Int) -> Int)? = null
        assertNull(canBeNull)

        // it could still be called this way
        assertNull(canBeNull?.invoke(1, 3))
    }

    @Test
    fun testParameterNames() {
        // A function that accepts a number and another function as parameters.
        // The parameter of the accepted function is called "fparam" here but can actually be different
        fun caller(param: Int, f: (fparam: Int) -> Int): Int {
            return f(param)
        }

        // This is the passed function as lambda. Here the paramter name is just "i" and not "fparam".
        val callee: (i: Int) -> Int = { i -> 2 * i }

        assertEquals(6, caller(3, callee))
    }

    @Test
    fun testReturn() {
        fun return2OrNull(numbers: List<Int>): Int? {
            numbers.forEach {
                // This is a lambda function. The return exits the return2OrNull and not just the lambda!
                if (it == 2) {
                    return 2
                }
            }
            return null
        }

        assertEquals(2, return2OrNull(listOf(1, 2, 3)))
        assertNull(return2OrNull(listOf(1, 3)))
    }

    @Test
    fun testReturnLabel() {
        var list = ArrayList<Int>()
        (10..12).forEach mylabel@{
            if (it == 11) return@mylabel // would return the lambda function but now acts like `continue`
            list.add(it)
        }

        assertEquals(listOf(10, 12), list)
    }

    @Test
    fun testReturnLabel2() {
        var list = ArrayList<Int>()
        (10..12).forEach {
            if (it == 11) return@forEach // returns to the function name `foreach`
            list.add(it)
        }

        assertEquals(listOf(10, 12), list)
    }
}
