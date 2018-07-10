package book.chapter11.myhtml2

abstract class Tag(val name: String) {
    val children = mutableListOf<Tag>()
    open fun html(): String = "<$name>" + children.map { it.html() }.joinToString("") + "</$name>"
}

class HTML : Tag("html") {
    fun table(init: TABLE.() -> Unit) = children.add(TABLE().apply(init))
    fun div(init: DIV.() -> Unit) = children.add(DIV().apply(init))
}

class DIV : Tag("div") {
    fun cdata(content: String) = children.add(CDATA(content))
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