package book.chapter5

import kotlin.test.Test
import kotlin.test.assertEquals

class MemberReferenceTest {
    class Person(val name: String, val age: Int) {
        fun onlyOver30() = age >= 30
    }

    @Test
    fun testMemberReferences() {
        val people = listOf(Person("alice", 29), Person("Bob", 31))

        // classic chain using lambdas
        val over30 = people.filter { it.age >= 30 }.map { it.name }
        assertEquals(listOf("Bob"), over30)

        // notice that map() takes a "member references" as parameter and not a lambda!
        val over30b = people.filter { it.age >= 30 }.map(Person::name)
        assertEquals(listOf("Bob"), over30b)

        // Here the filter takes a "member reference" to a function and not a lambda
        val over30c = people.filter(Person::onlyOver30).map(Person::name)
        assertEquals(listOf("Bob"), over30c)
    }
}