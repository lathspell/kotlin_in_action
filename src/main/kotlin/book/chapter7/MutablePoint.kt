package book.chapter7


data class MutablePoint(var x: Int, var y: Int) {

    operator fun get(pos: Char): Int {
        return when (pos) {
            'X' -> x
            'Y' -> y
            else -> throw Exception("Invalid index $pos, need X or Y!")
        }
    }

    operator fun set(pos: Char, value: Int) {
        when (pos) {
            'X' -> x = value
            'Y' -> y = value
            else -> throw Exception("Invalid index $pos, need X or Y!")
        }
    }
}
