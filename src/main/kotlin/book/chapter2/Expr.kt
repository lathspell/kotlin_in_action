package book.chapter2

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun evalJavaStyle(e: Expr): Int {
    if (e is Num) {
        return e.value
    }
    if (e is Sum) {
        return evalJavaStyle(e.left) + evalJavaStyle(e.right)
    }
    throw Exception("Type not implemented!")
}

fun eval(e: Expr): Int =
        when (e) {
            is Num -> e.value
            is Sum -> eval(e.left) + eval(e.right)
            else -> throw Exception("Type not implemented!")
        }
