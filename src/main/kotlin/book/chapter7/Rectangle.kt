package book.chapter7

class Rectangle(var upperLeft: Point, var lowerRight: Point) {

    operator fun contains(p: Point): Boolean {
        return p.x in upperLeft.x until lowerRight.x &&
                p.y in upperLeft.y until lowerRight.y
    }

}