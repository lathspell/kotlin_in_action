package book.chapter2

import java.util.*

// Listing 2.24
fun toBinary1() {

    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("Letter $letter is binary $binary")
    }
}

fun toBinaryString(s: String): String {
    val binaryReps = ('A'..'F').associate { Pair(it, Integer.toBinaryString(it.toInt())) }
    return s.map { binaryReps[it] }.joinToString(" ")
}