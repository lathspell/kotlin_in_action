data class Person(val name: String, val age: Int? = null)

fun main(args: Array<String>) {
    val persons = listOf(Person("Alice"), Person("Bob", 29))
    val oldest = persons.maxBy { it.age ?: 0 }
    println("Oldest: $oldest")
}