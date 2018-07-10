package book.chapter11

import kotlin.test.Test
import kotlin.test.assertEquals

class MyHtmlTest2 {

    @Test
    fun test1() {
        val html = HTML().apply {
            table {
                tr {
                    listOf(
                            td { cdata("foo") },
                            td { cdata("bar") })
                }
            }
        }

        val expected = "<html><table><tr><td>foo</td><td>bar</td></tr></table></html>"
        assertEquals(expected, html.html())
    }

    abstract class Tag(val name: String) {
        val children = mutableListOf<Tag>()
        open fun html(): String = "<$name>" + children.map { it.html() }.joinToString("") + "</$name>"
    }

    class HTML : Tag("html") {
        fun table(init: TABLE.() -> Unit) = children.add(TABLE().apply(init))
    }

    class TABLE : Tag("table") {
        fun tr(init: TR.() -> Unit) = children.add(TR().apply(init))
    }

    class TR : Tag("tr") {
        fun td(init: TD.() -> Unit) = children.add(TD().apply(init))
    }

    class TD : Tag("td") {
        fun cdata(content: String) = children.add(CDATA(content))
    }

    class CDATA(private val content: String) : Tag("") {
        override fun html() = content
    }

}
