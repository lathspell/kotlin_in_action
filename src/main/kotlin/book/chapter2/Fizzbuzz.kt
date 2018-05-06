package book.chapter2

fun fizzbuzz(range: IntProgression) =
        range.map { i -> fizzbuzz(i) }.joinToString(", ")

fun fizzbuzz(i: Int): String =
        when {
            i % 15 == 0 -> "fizzbuzz"
            (i % 5) == 0 -> "buzz"
            (i % 3) == 0 -> "fizz"
            else -> "$i"
        }