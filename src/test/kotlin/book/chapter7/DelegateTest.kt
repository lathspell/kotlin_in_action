package book.chapter7

import book.chapter7.mydate.Mydate
import java.util.*
import kotlin.reflect.KProperty
import kotlin.test.Test
import kotlin.test.assertTrue

class DelegateTest {
    class MydateTestDelegator {
        operator fun getValue(obj: DelegateTest, prop: KProperty<*>): Mydate {
            println("MydateTestDelegator.getValue()")
            val rnd = 6000 + Random().nextInt(5) // doing expensive computation
            return Mydate(rnd)
        }
    }

    val d0: Mydate = { println("initializer block"); Mydate(42) }.invoke()

    val d1: Mydate by MydateTestDelegator() // only initialized when actually accessed

    val d2: Mydate by lazy { println("lazy"); Mydate(3000 + Random().nextInt(10)) }

    @Test
    fun test1() {
        println("test1")
        // at this point "d" and "d2" are not yet initialized!
        assertTrue(d0.seconds == 42)
        assertTrue(d1.seconds in 6000..6005) // now "d" is initialized by calling MydateTestDelegator.getValue()
        assertTrue(d2.seconds in 3000..3010) // now "d2" is initialized by calling the "lazy" block
    }
}