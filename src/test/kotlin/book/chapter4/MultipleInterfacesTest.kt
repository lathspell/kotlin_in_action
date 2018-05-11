package book.chapter4

import kotlin.test.Test
import kotlin.test.assertEquals

interface MyFirstInterface {
    fun greeting(): String = "Hello"
}

interface MySecondInterface {
    fun greeting(): String = "Hi"
}

class MyImplementation : MyFirstInterface, MySecondInterface {

    override fun greeting(): String = "Hey"

    fun greeting2(): String {
        // Explicitly telling the compiler which default implementation should be called
        return super<MySecondInterface>.greeting()
    }
}

class MultipleInterfacesTest {
    @Test
    fun test1() {
        assertEquals("Hey", MyImplementation().greeting())
    }

    @Test
    fun test2() {
        assertEquals("Hi", MyImplementation().greeting2())
    }
}