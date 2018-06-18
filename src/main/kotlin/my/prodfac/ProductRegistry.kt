package my.prodfac

object ProductRegistry {
    val registry = HashSet<Product>()

    fun register(product: Product) {
        println("Registering: $product")
        registry.add(product)
    }

    fun fromId(id: Int): Product {
        return registry.first { it.id == id }
    }

}