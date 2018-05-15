package book.chapter4

import kotlin.test.Test
import kotlin.test.assertEquals

// Implementing the Singleton pattern in Kotlin is much easier than in Java.
class SingletonTest {
    open class ParentSingle

    object TheSingle : ParentSingle() {

        // private property that has a public getter
        var counter: Int
            private set

        init {
            println("TheSingle init")
            counter = 0 // only executed once, not for every use of "TheSingle"
            // ...
        }

        fun inc() = counter++
    }

    @Test
    fun test() {
        TheSingle.inc()
        TheSingle.inc()
        // not allowed due to private setter: TheSingle.counter = 666
        assertEquals(2, TheSingle.counter)
    }
}