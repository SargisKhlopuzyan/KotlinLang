package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas.lambdas

/**
 * Created by Sargis Khlopuzyan, on 2/21/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * INFO-TODO
 * A lambda expression or anonymous function (as well as a local function and an object expression)
 * can access its closure, i.e. the variables declared in the outer scope.
 * The variables captured in the closure can be modified in the lambda:
 */
fun main() {
    var sum = 0
    val ints = intArrayOf(1, 2, 3, 4, 5)
    ints.filter { it > 0 }.forEach {
        sum += it
    }
    print(sum)
}