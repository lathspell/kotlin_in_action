package book.chapter11

import kotlin.test.Test
import kotlin.test.assertEquals

class MyHtmlTest {

    @Test
    fun test1() {
        val html = HTML.createHtml {
            table { tr { td { cdata { text("foo") } } } }
        }
        val expected = "<html><table><tr><td>foo</td></tr></table></html>"
        assertEquals(expected, html.html())
    }

    abstract class Tag {
        val children = mutableListOf<Tag>()
        open fun html(): String = children.map { openTag() + it.html() + closeTag() }.joinToString("")
        abstract fun openTag(): String
        abstract fun closeTag(): String
    }

    class HTML : Tag() {

        companion object {
            fun createHtml(init: HTML.() -> Unit): HTML {
                val html = HTML()
                html.init()
                return html
            }
        }

        fun table(init: TABLE.() -> Unit) {
            val table = TABLE()
            table.init()
            children.add(table)
        }

        override fun openTag() = "<html>"
        override fun closeTag() = "</html>"
    }

    class TABLE : Tag() {
        fun tr(init: TR.() -> Unit) {
            val tr = TR()
            tr.init()
            children.add(tr)
        }

        override fun openTag() = "<table>"
        override fun closeTag() = "</table>"
    }

    class TR : Tag() {
        fun td(init: TD.() -> Unit) {
            val td = TD()
            td.init()
            children.add(td)
        }

        override fun openTag() = "<tr>"
        override fun closeTag() = "</tr>"
    }

    class TD : Tag() {
        fun cdata(init: CDATA.() -> Unit) {
            val cdata = CDATA()
            cdata.init()
            children.add(cdata)
        }

        override fun openTag() = "<td>"
        override fun closeTag() = "</td>"
    }

    class CDATA : Tag() {
        private var content: String = ""

        fun text(s: String) {
            this.content = s
        }

        override fun html() = content
        override fun openTag() = ""
        override fun closeTag() = ""
    }

}
