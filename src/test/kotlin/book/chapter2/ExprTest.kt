package book.chapter2

import kotlin.test.Test
import kotlin.test.assertEquals

class ExprTest {

    @Test
    fun test1() {
        assertEquals(7, evalJavaStyle(Sum(Sum(Num(1), Num(2)), Num(4))))
    }

    @Test
    fun test2() {
        assertEquals(7, eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    }
}