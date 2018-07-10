package book.chapter11

import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.startsWith
import org.hamcrest.Matcher
import kotlin.test.Test

class ChainingInfixTest {

    private infix fun <T> T.must(that: Matcher<T>) = that.matches(this)

    @Test
    fun testInfix() {
        "Foo" must startsWith("F")
    }

    @Test
    fun testExplainViaAlternativeSyntax() {
        // The "infix" translates the above call into the following:
        "Foo".must(startsWith("F"))
        // Ignoring the static import it's:
        "Foo".must(CoreMatchers.startsWith("F"))
        // Replacing the infix call by the function body of must() produces:
        CoreMatchers.startsWith("F").matches("Foo")
    }

}
