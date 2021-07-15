package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas2

/**
 * Created by Sargis Khlopuzyan, on 8/19/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    read(b = arrayOf(1, 2), text = "text")

    val sub = Sub()
    sub.abstractFunction(xx = 45, zz = arrayOf(5, 6, 7))

    val lambda = { xx: Int, yy: Int -> xx > yy }

    lastArgumentAfterDefaultParametersIsALambda(5, 6, { xx, yy -> xx > yy })
    lastArgumentAfterDefaultParametersIsALambda(5, 6) { xx, yy -> xx > yy }
    lastArgumentAfterDefaultParametersIsALambda(5, 6, lambda)
    lastArgumentAfterDefaultParametersIsALambda(1, lambda = lambda)
    lastArgumentAfterDefaultParametersIsALambda(lambda = lambda)
    lastArgumentAfterDefaultParametersIsALambda(lambda = { xx, yy -> xx > yy })
}

// Default arguments
fun read(b: Array<Byte>, off: Int = 0, len: Int = b.size, text: String) {
    /*...*/
}

abstract class Super {
    fun functionWithDefaultArguments(x: Int, y: String = "text", z: Array<Int>) {}
    abstract fun abstractFunction(xx: Int, yy: String = "texttext", zz: Array<Int>)
}

class Sub : Super() {
    /**
     * Overriding methods always use the same default parameter values as the base method.
     * When overriding a method with default parameter values, the default parameter values must be omitted from the signature:
     * */
    // No default value is allowed
    override fun abstractFunction(xx: Int, yy: String, zz: Array<Int>) {}
}

fun lastArgumentAfterDefaultParametersIsALambda(
    x: Int = 0,
    y: Int = 1,
    lambda: (xx: Int, yy: Int) -> Boolean
) {
    if (lambda(x, y)) {
        println("is in lambda")
    } else {
        println("out of lambda")
    }
}

fun foo(bar: Int = 0, baz: Int = 1, qux: () -> Unit) { /*...*/
}