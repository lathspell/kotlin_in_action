package book.chapter6

import kotlin.test.Test

/**
 * The Kotlin "Nothing" type is not a language construct but a regular class.
 * It does have a private constructor, though, and is therefore impossible to instantiate.
 * It is use to not only mark a class as returning nothing but even as "never ever returning at all"
 * as the compiler demands either a "throw" or a "return" and the latter is impossible to write.
 */
class NothingTest {

    private fun broken(): Nothing {
        throw Exception("can't return")
    }

    @Test(expected = Exception::class)
    fun testUnit() {
        broken()
    }

}