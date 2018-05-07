package book.chapter1

import kotlin.test.Test
import kotlin.test.assertEquals

data class Person(val name: String, val age: Int? = null)

class Test_1_1 {
    @Test
    fun test_1_1() {
        val persons = listOf(Person("Alice"), Person("Bob", 29))
        val oldest = persons.maxBy { it.age ?: 0 }
        assertEquals("Bob", oldest!!.name)
    }
}