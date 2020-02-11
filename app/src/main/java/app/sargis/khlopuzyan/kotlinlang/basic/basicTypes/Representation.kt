package app.sargis.khlopuzyan.kotlinlang.basic.basicTypes

/**
 * Created by Sargis Khlopuzyan, on 2/10/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

    labelFunction()
    labelFunctionWithLiteralForEach()
    labelFunctionWithForEach()
    labelFunctionWithRunAndLiteral()


    val s = "Hello, world!" +
            "test"
    println(s)

    val s2 =
        """"Hello, world!
            >test""".trimMargin(">")
    println(s2)

    val price = """
        |${'$'}9.99
        |""".trimMargin()
    println(price)

}

fun labelFunction() {
    labelMainFor@ for (i in 1..10) {
        labelSecondFor@ for (j in 1..10) {
            if (i == 5 && j == 5)
                break@labelMainFor
        }
    }
}

fun labelFunctionWithLiteralForEach() {

    listOf(1, 2, 3, 4, 5).forEach literalForEach@{
        if (it == 3) return@literalForEach
        if (it == 4) return
        println(it)
    }

    println("done with explicit label")
}

fun labelFunctionWithForEach() {

    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 4) return@forEach
        println(it)
    }

    println("done with explicit label")
}

fun labelFunctionWithRunAndLiteral() {

    var resultValue = run literalLoop@{

        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@literalLoop 123456789
            println(it)
        }
    }

    println("done with explicit label -> resultValue: $resultValue")
}