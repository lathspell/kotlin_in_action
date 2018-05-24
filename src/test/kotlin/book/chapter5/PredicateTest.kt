package book.chapter5

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PredicateTest {
    class Person(val name: String, val age: Int) {
        fun onlyOver30() = age >= 30
    }

    val alice = Person("Alice", 29)
    val bob = Person("Bob", 31)
    val charlie = Person("Charlie", 29)
    val people = listOf(alice, bob, charlie)

    @Test
    fun testPredicates() {
        // checks *all* entries
        val areAllMembersOver30 = people.all(Person::onlyOver30)
        assertFalse(areAllMembersOver30)

        // checks if *any* entry matches (lambda or member reference does not matter)
        val isAnyMemberOver30 = people.any { it.age >= 30 }
        assertTrue(isAnyMemberOver30)

        // count is faster than filtering and ".size" as it does not create temporary lists
        val numPeopleOver20 = people.count { it.age > 20 }
        assertEquals(3, numPeopleOver20)
    }

    @Test
    fun testGrouping() {
        val groupedByAge = people.groupBy { it.age }
        assertEquals(mapOf(29 to listOf(alice, charlie), 31 to listOf(bob)), groupedByAge)

        // mapValues() can apply a mapping to the values of a map
        val namesByAge = people.groupBy(Person::age).mapValues { it.value.map(Person::name) }
        assertEquals(mapOf(29 to listOf("Alice", "Charlie"), 31 to listOf("Bob")), namesByAge)

        // flatMap first creates a list for every iterated element and then combines those lists. toSet() removes duplicates
        val allNames = people.groupBy(Person::age).flatMap { listOf(it.key) }.toSet()
        assertEquals(setOf(29, 31), allNames)
    }

}