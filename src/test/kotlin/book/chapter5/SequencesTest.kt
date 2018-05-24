package book.chapter5

import java.util.stream.Collectors
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Testing Kotlin Sequences.
 */
class SequencesTest {
    class Person(val name: String, val age: Int) {
        fun onlyOver30() = age >= 30
    }

    val alice = Person("Alice", 29)
    val bob = Person("Bob", 31)
    val charlie = Person("Charlie", 29)
    val people = listOf(alice, bob, charlie)

    // Kotlin Sequences can be a substitute for Java Streams if those are unavailable (e.g. on Android). No Parallelism though.
    @Test
    fun testSequences() {
        val theBs = people.asSequence().filter { it.name.startsWith("B") }.map { it.name }.toList()
        assertEquals(listOf("Bob"), theBs)
    }

    // Java Streams work fine if they are available on the target platform (like a JVM)
    @Test
    fun testJavaStreams() {
        val theBs = people.parallelStream().filter { it.name.startsWith("B") }.map { it.name }.collect(Collectors.toList())
        assertEquals(listOf("Bob"), theBs)
    }
}