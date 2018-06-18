package book.chapter7.mydate

data class Mydate(val seconds: Int) : Comparable<Mydate> {
    override fun compareTo(other: Mydate): Int = seconds.compareTo(other.seconds)
}

internal class MydateProgression(private val from: Int, private val to: Int, private val step: Int = 1) : Iterable<Mydate> {
    override fun iterator(): Iterator<Mydate> = MydateProgressionIterator(from, to, step)
}

internal class MydateProgressionIterator(from: Int, private val to: Int, private val step: Int = 1) : Iterator<Mydate> {
    private var current = from

    override fun hasNext() = current <= to

    override fun next(): Mydate {
        val result = Mydate(current)
        current += step
        return result
    }
}
