package my.prodfac2

enum class Product(val id: Int, val helper: ProductColorizer) {
    RED_PRODUCT(1, RedProductColorizer),
    GREEN_PRODUCT(2, GreenProductColorizer);

    companion object {
        fun byId(id: Int): Product {
            return values().first { it.id == id }
        }
    }
}