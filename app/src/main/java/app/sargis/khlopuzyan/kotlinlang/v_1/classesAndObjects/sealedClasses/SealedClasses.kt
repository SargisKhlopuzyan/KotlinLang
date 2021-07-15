package app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.sealedClasses

/**
 * Created by Sargis Khlopuzyan, on 2/12/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

    val expr: Expr =
        Const(
            123.0
        )

    when (expr) {
        is Const -> expr.number
//        is Sum -> eval(expr.e1) + eval(expr.e2)
//        NotANumber -> Double.NaN
        // the `else` clause is not required because we've covered all the cases
    }
}

sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()


/**
 * The key benefit of using sealed classes comes into play when you use them in a when expression.
 * If it's possible to verify that the statement covers all cases, you don't need to add an else clause to the statement.
 * However, this works only if you use when as an expression (using the result) and not as a statement.
 * */
fun eval(expr: Expr): Double = when (expr) {
    is Const -> expr.number
    is Sum -> eval(
        expr.e1
    ) + eval(
        expr.e2
    )
    NotANumber -> Double.NaN
    // the `else` clause is not required because we've covered all the cases
}