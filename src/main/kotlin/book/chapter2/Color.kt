package book.chapter2

/** Listing 2.10 */
enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET;

    companion object {

        fun getMnemonic(color: Color) =
                when (color) {
                    Color.RED -> "Richard"
                    Color.ORANGE -> "Of"
                    Color.YELLOW -> "York"
                    else -> throw Exception("Lazyness...")
                }

        fun getWarmth(color: Color) = when (color) {
            Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
            Color.GREEN -> "neutral"
            Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
        }

        fun mix(c1: Color, c2: Color) =
                when (setOf(c1, c2)) {
                    setOf(RED, YELLOW) -> ORANGE
                    setOf(YELLOW, BLUE) -> GREEN
                    setOf(BLUE, VIOLET) -> INDIGO
                    else -> throw Exception("Dirty color!")
                }

        fun mixOptimized(c1: Color, c2: Color) : Color {
            val s = setOf(c1, c2).sorted() // avoid error prune OR-comparison
            return when {
                (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
                (c1 == YELLOW && c2 == BLUE) || (c1 == BLUE && c2 == YELLOW) -> GREEN
                (s[0] == BLUE && s[1] == VIOLET) -> INDIGO
                else -> throw Exception("Dirty color!")
            }
        }
    }
}