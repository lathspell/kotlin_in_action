package book.chapter2

/** Listing 2.11 */
enum class Color2(
        val r: Int, val g: Int, val b: Int
) {
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}
