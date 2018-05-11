package book.chapter4

import kotlin.test.Test
import kotlin.test.assertEquals

// Kotlin classes and methods are final by default
open class Foo(val id: String) {

    var id2: String = ""

    constructor(id: String, id2: String) : this(id) {
        this.id2 = id2
    }

    // even methods are final by default
    open fun getIds() = "This is $id/$id2"
}

class Bar(id: String) : Foo(id) {
    // overriding methods need a special keyword to avoid accidentally hiding them
    override fun getIds() = "This is $id/$id2 from Bar"
}

// The keyword "constructor" is optional.
class Baz constructor(val bazzy: Int) : Foo("Baz")

class SubclassTest {

    @Test
    fun test1() {
        val foo = Foo("foo1")
        assertEquals("This is foo1/", foo.getIds())

        val foo2 = Foo("foo1", "a")
        assertEquals("This is foo1/a", foo2.getIds())

        val foobar: Foo = Bar("bar1")
        assertEquals("This is bar1/ from Bar", foobar.getIds())

        val baz = Baz(4)
        assertEquals("This is Baz/", baz.getIds())
        assertEquals("Baz", baz.id)
        assertEquals(4, baz.bazzy)
    }

}