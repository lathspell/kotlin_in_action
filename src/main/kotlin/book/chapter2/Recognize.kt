package book.chapter2

class Recognize {
    companion object {

        @JvmStatic
        fun recognize(s: String): String =
                (s.toCharArray().map { recognize(it) }).joinToString("")

        private fun recognize(c: Char): String =
                when (c) {
                    in '0'..'9' -> "d"
                    in 'a'..'z', in 'A'..'Z' -> "c"
                    else -> "x"
                }
    }
}