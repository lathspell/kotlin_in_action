package book.chapter4

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class EqualsTest {

    class Person1(val name: String)

    class Person2(val name: String) {
        override fun equals(that: Any?): Boolean {
            return that !== null
                    && that is Person2
                    && this.name == that.name
        }
    }

    data class Person3(val name: String) // overwrites equals()

    @Test
    fun testEqualsMethod() {
        assertFalse(Person1("foo") == Person1("foo")) // uses Object.equals()
        assertTrue(Person2("foo") == Person2("foo")) // uses overridden Person2.equals()
        assertTrue(Person3("foo") == Person3("foo")) // uses overridden Data Class .euquals()
    }

    @Test
    fun testEqualsOperator() {
        val s1 = "foo"
        val s2 = "foo123".substring(0, 3) // also "foo" but not build from a string literal so not the same reference

        // in contrast to Java, comparing Strings with "==" does work in Kotlin
        // it's actually an infix operator that just calls ".equals()"
        assertTrue(s1 == s2)

        // hashCode() is implemented differently as in Java, it's contract mandates
        // that the hashCode is identical if the objects are equal according to ".equals()"
        assertTrue(s1.hashCode() == s2.hashCode())

        val i1: Int = 42
        val i2: Integer = Integer(42)
        // Comparing a Kotlin "Int" with a Java "Integer" does not work
        // Comparing a Kotlin "Int" with a Java "int" does work
        assertTrue(i1 == i2.toInt())
        // The "Int" and the "int" have the same hashCode as required in Kotlin if they are equals according to ".equals()"
        assertTrue(i1.hashCode() == i2.hashCode())
    }
}