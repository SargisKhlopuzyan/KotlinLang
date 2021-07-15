package app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.propertiesAndFields

/**
 * Created by Sargis Khlopuzyan, on 2/11/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    setterVisibility = "cba"
}

var size = 10

val isEmpty: Boolean
    get() = size == 0

var stringRepresentation: String = ""
    get() = size.toString()
    set(value) {
        field = value
    }

var setterVisibility: String = "abc"
    private set

