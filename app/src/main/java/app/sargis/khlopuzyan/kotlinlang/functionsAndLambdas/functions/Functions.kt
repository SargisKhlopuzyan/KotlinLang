package app.sargis.khlopuzyan.kotlinlang.functionsAndLambdas.functions

/**
 * Created by Sargis Khlopuzyan, on 2/17/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    val a = A()
    val b = B()


//    a.go(1, 2)
//    b.go(1, 2)

    a.stopWithLambda(
        1,
        2,
        {
            if (it > 5) {
                println("$it > 5")
            } else {
                println("$it <= 5")
            }
        }
    )

    a.stopWithLambda(
        2,
        1,
        compareAndPrint = {
            if (it > 5) {
                println("$it > 5")
            } else {
                println("$it <= 5")
            }
        }
    )

    a.stopWithLambda(
        x = 3,
        y = 4,
        compareAndPrint = {
            if (it > 5) {
                println("$it > 5")
            } else {
                println("$it <= 5")
            }
        }
    )

    a.stopWithLambda(1, 4) {
        if (it > 5) {
            println("$it > 5")
        } else {
            println("$it <= 5")
        }
    }

    function1(123)
}

open class A {

    open fun go(bar: Int = 30, baz: Int) {
        println("A -> go(...)")
    }

    open fun stopWithLambda(x: Int, y: Int, compareAndPrint: (z: Int) -> Unit) {
        println("A -> stopWithLambda(...)")
        compareAndPrint(x + y)
    }

}

class B : A() {

    //    override fun foo(bar: Int = 50, baz: Int) {} // Error!! no default value allowed
    //    override fun foo(baz: Int) {} // Error!!
    override fun go(bar: Int, baz: Int) {
        super.go(bar = bar, baz = baz)
        println("B -> go(...)")
    }

    override fun stopWithLambda(x: Int, y: Int, compareAndPrint: (z: Int) -> Unit) {
        super.stopWithLambda(x, y, compareAndPrint)
        println("B -> stopWithLambda(...)")
        compareAndPrint(7777)
    }
}

// TODO IMPORTANT
var function1: Function1<Int, Unit> = fun(value: Int) {
    println("Function1<Int, Unit>: value: $value")
}

var function1_1 = fun(value: Int) {
    println("Function1<Int, Unit>: value: $value")
}