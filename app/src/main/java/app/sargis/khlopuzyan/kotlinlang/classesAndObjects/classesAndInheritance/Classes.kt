package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.classesAndInheritance

/**
 * Created by Sargis Khlopuzyan, on 2/10/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */
fun main() {
//    InitOrderDemo("Ssss")

    Constructors(2)
}

class Person constructor(firstName: String) { /*...*/ }

class Person2(firstName: String) { /*...*/ }

class InitOrderDemo(name: String) {

    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints ${name}")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

class Constructors constructor(str: String) {

    constructor(i: Int): this(i.toString()) {
        println("Constructor")
    }

    init {
        println("Init block")
    }
}