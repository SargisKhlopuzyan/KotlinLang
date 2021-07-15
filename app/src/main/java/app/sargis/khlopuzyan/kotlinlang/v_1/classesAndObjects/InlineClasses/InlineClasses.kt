package app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.InlineClasses


/**
 * //INFO-TODO
 * No actual instantiation of class 'Password' happens
 * At runtime 'securePassword' contains just 'String'
 *
 * INFO-TODO
 * There are some restrictions for inline class members:
 *
 * - inline classes cannot have init blocks
 * - inline class properties cannot have backing fields
 *   - it follows that inline classes can only have simple computable properties (no lateinit/delegated properties
 *
 * - inline classes are allowed to inherit from interfaces
 *
 * - It is forbidden for inline classes to participate in a class hierarchy.
 *   This means that inline classes cannot extend other classes and must be final
 * */
fun main() {

    val name = Name("Kotlin")

    name.greet() // method `greet` is called as a static method
    println(name.length) // property getter is called as a static method
    println(name.prettyPrint()) // Still called as a static method

    println(name)

    main2()
}


// IMPORTANT-TODO
/*open*/ inline class Name(val s: String) : Printable {

    val length
        get() = s.length

    fun greet() {
        println("Hello, $s")
    }

    override fun prettyPrint(): String {
        return "Let's $s!"
    }
}

interface Printable {
    fun prettyPrint(): String
}

//class MyClass(s: String): Name(s) {}

//*****************************************************************************

interface I

inline class Foo(val i: Int) : I

fun asInline(f: Foo) {}
fun <T> asGeneric(x: T) {}
fun asInterface(i: I) {}
fun asNullable(i: Foo?) {}

fun <T> id(x: T): T = x

fun main2() {
    val f = Foo(42)

    asInline(f)    // unboxed: used as Foo itself
    asGeneric(f)   // boxed: used as generic type T
    asInterface(f) // boxed: used as type I
    asNullable(f)  // boxed: used as Foo?, which is different from Foo

    // below, 'f' first is boxed (while being passed to 'id') and then unboxed (when returned from 'id')
    // In the end, 'c' contains unboxed representation (just '42'), as 'f'
    val c = id(f)
}