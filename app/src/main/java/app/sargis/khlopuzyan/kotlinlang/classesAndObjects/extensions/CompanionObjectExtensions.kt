package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.extensions

/**
 * Created by Sargis Khlopuzyan, on 2/11/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    MyClass.printCompanion()
}

class MyClass {
    companion object
}

fun MyClass.Companion.printCompanion() {
    println("companion extension function")
}
