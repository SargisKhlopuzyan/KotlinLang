package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.delegation

fun main() {

    val b = BaseImpl(10)
    val derived = Derived(b)

    derived.printMessage()
    derived.printMessageLine()

    println(derived.message)

}

interface Base {
    val message: String
    fun printMessage()
    fun printMessageLine()
}

class BaseImpl(val x: Int) : Base {

    override val message = "BaseImpl: x = $x"

    override fun printMessage() {
        print(x)
    }

    override fun printMessageLine() {
        println(x)
    }

}

/**
 * The by-clause in the supertype list for Derived indicates that b will be stored internally in
 * objects of Derived and the compiler will generate all the methods of Base that forward to b.
 * */
class Derived(b: Base) : Base by b {

    // This property is not accessed from b's implementation of `print`
    override val message = "Message of Derived"

    override fun printMessage() {
        println("abc")
    }
}