package app.sargis.khlopuzyan.kotlinlang.gettingStarted.codingConventions

/**
 * Created by Sargis Khlopuzyan, on 2/7/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
//    println(tryCatch(null))
    foo()
}

var size = 0

val isEmpty: Boolean
    get() {
        return size == 0
    }

var ints = listOf(1, 2, 3)

fun foo() {
    ints.forEach lit@{
        println(it)
        return@lit
        println(it)
    }
}

fun tryCatch(text: Int?): String {

    try {
        val xxxxxx = text!! / 5
        println(xxxxxx)
        return "try"
    } catch (e: KotlinNullPointerException) {
        return "catch"
    } finally {
        return "finally"
    }

}

fun functionFooImpl(): Foo {
    return FooImpl()
}

class FooImpl : Foo() {
    override fun abstractFunctionFoo() {}
}

abstract class Foo {
    abstract fun abstractFunctionFoo()
    fun functionFoo() {}
}