package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas2.functions

fun main() {

    foo1(1)
//    foo2(1) // Error - No value passed for parameter 'baz'
    foo2(baz = 1)

    // ***************************************

    // No1 - Uses the default value baz = 1
    foo3(1) {
        println("hello")
    }

    // N2 - Uses both default values bar = 0 and baz = 1
    foo3 { println("hello") }
    foo3(qux = { println("hello") })

    // ***************************************

    // We could call this using default arguments:
    reformat("str")

    // However, when calling it with non-default, the call would look something like:
    reformat("str", true, true, false, '_')

    // With named arguments we can make the code much more readable:
    reformat(
        "str",
        normalizeCase = true,
        upperCaseFirstLetter = true,
        divideByCamelHumps = false,
        wordSeparator = '_'
    )

    // and if we do not need all arguments:
    reformat("str", wordSeparator = '_')

    // ***************************************

    // When a function is called with both positional and named arguments,
    // all the positional arguments should be placed before the first named one.
    // For example, the call f(1, y = 2) is allowed, but f(x = 1, 2) is not.
    f(1, y = 10)
//    f(x = 1, 10) // Error

    // ***************************************

    varargFun("a", "b", "c", "d")
    var array = arrayOf("a", "b", "c", "d")
    varargFun(strings = *array)
}

// Default arguments
fun read(b: Array<Byte>, off: Int = 0, len: Int = b.size) { /*...*/

}

open class A {
    open fun foo(i: Int = 10) {}
}

class B : A() {

    // no default value allowed
    override fun foo(i: Int /*= 20*/) {
        super.foo(i)
    }
}

// **********************************************

fun foo1(baz: Int, bar: Int = 0) { /*...*/
}

// If a default parameter precedes a parameter with no default value,
// the default value can only be used by calling the function with named arguments:
// No1
fun foo2(bar: Int = 0, baz: Int) { /*...*/
}

// If the last argument after default parameters is a lambda,
// it can be passed in either as a named argument or outside the parentheses:
// No2
fun foo3(bar: Int = 0, baz: Int = 1, qux: () -> Unit) { /*...*/
}

// **********************************************

fun reformat(
    str: String,
    normalizeCase: Boolean = true,
    upperCaseFirstLetter: Boolean = true,
    divideByCamelHumps: Boolean = false,
    wordSeparator: Char = ' '
) {
/*...*/
}

// **********************************************

fun f(x: Int, y: Int) {
}

// **********************************************

fun varargFun(vararg strings: String) {

}