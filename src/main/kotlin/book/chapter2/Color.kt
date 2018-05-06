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
    }
}