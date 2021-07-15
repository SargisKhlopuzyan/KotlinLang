package app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.extensions

/**
 * Created by Sargis Khlopuzyan, on 2/11/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */


fun main() {

    val list = listOf("a", "b", "c", "d")
    list.lastIndexExtension
    list.firstIndexValExtension
    list.firstIndexVarExtension
}

val <T> List<T>.lastIndexExtension: Int
    get() = size - 1


val <T> List<T>.firstIndexValExtension: Int
    get() = 0

var <T> List<T>.firstIndexVarExtension: Int
    get() = this.size
    set(value) {}