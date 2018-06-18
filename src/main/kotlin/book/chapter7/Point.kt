package book.chapter7

data class Point(var x: Int, var y: Int) {
    // operator defined inside class
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    operator fun plusAssign(other: Point) {
        x += other.x
        y += other.y
    }

    operator fun unaryMinus() = Point(-x, -y)

    operator fun inc() = Point(x + 1, y + 1)

    override operator fun equals(other: Any?): Boolean {
        if (other == null) return false       // happens often -> optimization
        if (other === this) return true       // check for identity (compares reference like "==" in Java) -> optimization
        if (other !is Point) return false     // fail-fast if not even same type
        return x == other.x && y == other.y     // the "is" above "smart casts" other from Any to Point as a side effect!
    }
}

// operator defined outside class
operator fun Point.minus(other: Point): Point {
    return Point(x - other.x, y - other.y)
}