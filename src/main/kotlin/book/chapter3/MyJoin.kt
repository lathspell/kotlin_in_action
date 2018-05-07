@file:JvmName("MyJoinUtils")

// this will be the name of the .class file

package book.chapter3

@JvmOverloads // generates three additional myJoin() methods with default arguments for use with Java
fun <T> myJoin(elements: List<T>, separator: String = ", ", prefix: String = "", postfix: String = ""): String {
    var result = prefix
    for (i in 0..elements.size - 2) {
        result += elements[i]
        result += separator
    }
    result += elements[elements.size - 1]
    result += postfix
    return result
}

infix fun <T> List<T>.joinWith(serparator: String): String = myJoin(this, serparator, "", "")

fun <T> theirJoin(collection: Collection<T>, separator: String = ", ", prefix: String = "", postfix: String = ""): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}