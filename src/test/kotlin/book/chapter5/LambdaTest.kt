package book.chapter5

import org.junit.Test
import kotlin.test.assertEquals

class LambdaTest {

    @Test
    fun test() {
        val people = listOf(Person("max", 28), Person("Erika", 56), Person("Jens", 40))
        assertEquals("Erika", classicFindOldest(people)!!.name)
        assertEquals("Erika", modernFindOldest1(people)!!.name)
        assertEquals("Erika", modernFindOldest2a(people)!!.name)
        assertEquals("Erika", modernFindOldest2b(people)!!.name)
        assertEquals("Erika", modernFindOldest2c(people)!!.name)
        assertEquals("Erika", modernFindOldest2d(people)!!.name)
        assertEquals("Erika", modernFindOldest2e(people)!!.name)
        assertEquals("Erika", modernFindOldest3(people)!!.name)
    }

    private data class Person(val name: String, val age: Int)

    private fun classicFindOldest(people: List<Person>): Person? {
        var maxAge = 0
        var oldest: Person? = null
        for (person in people) {
            if (maxAge < person.age) {
                maxAge = person.age
                oldest = person
            }
        }
        return oldest
    }

    private fun modernFindOldest1(people: List<Person>): Person? {
        return people.sortedByDescending { p -> p.age }.first() // sorts whole list which takes a bit longer
    }

    private fun modernFindOldest2a(people: List<Person>): Person? {
        return people.maxBy({ p: Person -> p.age }) // maxBy accepts a lambda function as parameter
    }

    private fun modernFindOldest2b(people: List<Person>): Person? {
        return people.maxBy({ p -> p.age }) // improvement: the type can be inferred
    }

    private fun modernFindOldest2c(people: List<Person>): Person? {
        return people.maxBy { p -> p.age } // improvement: if a lambda is the only parameter to a function it can be written after it
    }

    private fun modernFindOldest2d(people: List<Person>): Person? {
        return people.maxBy { p -> p.age } // improvement: if a lambda is the only parameter to a function the "()" can be omitted
    }

    private fun modernFindOldest2e(people: List<Person>): Person? {
        return people.maxBy { it.age } // improvement: uses the Lambda short form with the special variable "it"
    }

    private fun modernFindOldest3(people: List<Person>): Person? {
        return people.maxBy(Person::age) // uses a "selector" instead of a Lambda
    }


}