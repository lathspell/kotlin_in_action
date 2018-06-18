package my.prodfac

abstract class Product {
    val id: Int

    constructor(id: Int) {
        this.id = id
        ProductRegistry.register(this)
    }

    abstract fun getColor(): String

}