package book.chapter4

import kotlin.test.Test
import kotlin.test.assertEquals

class InitializerBlockTest {

    // class definition with a "primary constructor" that sets an read-only ("val") instance property ("name")
    class User(val name: String)

    // class definition with a "primary constructor" (the word "constructor" is optional) that defines just a parameter
    // that is not stored in an instance property immediately. It can be accessed in an initialization block where it
    // is stored in the instance variable of the same name in this example.
    class User2 constructor(name: String) {
        val name: String

        init {
            this.name = name // instance variable is set to constructor parameter
        }
    }

    class User3(name: String) {
        fun tell(): String = "" // reference to "name" is not allowed, it's just a constructor parameter without a "var"/"val"
    }

    @Test
    fun test() {
        assertEquals("foo", User("foo").name)
        assertEquals("foo", User2("foo").name)
    }
}