package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas.lambdas

/**
 * Created by Sargis Khlopuzyan, on 2/19/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * INFO-TODO
 * You can also give a function type an alternative name by using a type alias:
 * */

typealias isTheSameNameFunction = (name: String, surname: String) -> Unit

fun main() {
    val result1: isTheSameNameFunction = myFunction1
    val result2: isTheSameNameFunction = myFunction2
    result1("AAA", "aaa")
    result2("BBB", "aaa")
}

val myFunction1: (String, String) -> Unit = { str1, str2 ->
    if (str1.equals(str2, true)) {
        println("$str1 = $str2")
    } else {
        println("$str1 != $str2")
    }
}

val myFunction2: (String, String) -> Unit = { str1, str2 ->
    if (str1.equals(str2, true)) {
        println("$str1 = $str2")
    } else {
        println("$str1 != $str2")
    }
}