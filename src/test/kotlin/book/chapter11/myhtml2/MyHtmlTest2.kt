package book.chapter11.myhtml2

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

    @Test
    fun test2() {
        val html = HTML().apply {
            for (i in 1..2) {
                div { cdata(i.toString()) }
            }
        }

        val expected = "<html><div>1</div><div>2</div></html>"
        assertEquals(expected, html.html())
    }

}
