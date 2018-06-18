package my.prodfac

object BrownProduct : Product(2) {
    override fun getColor() = "brown"

    init {
        println("init 2")
    }
}