package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.classesAndInheritance

/**
 * Created by Sargis Khlopuzyan, on 2/10/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

    Derived("Sargis", "Khlopuzyan")

}

open class Base(val name: String) {

    init {
        println("Initializing Base")
    }

    open val size: Int =
        name.length.also { println("Initializing size in Base: $it") }
}

class Derived(
    name: String,
    val lastName: String
) : Base(name.capitalize().also { println("Argument for Base: $it") }) {

    init {
        println("Initializing Derived")
    }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}