package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas.lambdas

/**
 * Created by Sargis Khlopuzyan, on 2/19/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    println(onClickWithParamsReturnFunction2("Message", 12))
    println(onClickWithParamsReturnFunction3("Message", 12))
    onClickWithParamsReturnFunction2("Message", 12)(4, 14)
}

/**
 * IMPORTANT-TODO
 *
 * To specify that a function type is nullable, use parentheses: ((Int, Int) -> Int)?.
 * Function types can be combined using parentheses: (Int) -> ((Int) -> Unit)
 * The arrow notation is right-associative, (Int) -> (Int) -> Unit is equivalent to the previous example, but not to ((Int) -> (Int)) -> Unit.
 * */

val onClickNullable: (() -> Unit)? = {
    println("in onClick function")
}

val onClickWithParamsReturnFunction2: (String, Int) -> ((Int, Int) -> Unit) = { str, value ->

    //OK
    returnFunction2

    //OK
//    fun(x: Int, y: Int) {
//        println("x: $x, y: $y")
//    }
}

val onClickWithParamsReturnFunction3: (String, Int) -> ((Int, Int, Int) -> Unit) = { str, value ->

    //OK
//    returnFunction3

    //OK
    fun(x: Int, y: Int, z: Int) {
        println("x: $x, y: $y, z: $z")
    }
}

val returnFunction2: (Int, Int) -> Unit = { x, y ->
    println("x: $x, y: $y")
}

val returnFunction3: (Int, Int, Int) -> Unit = { x, y, z ->
    println("x: $x, y: $y, z: $z")
}