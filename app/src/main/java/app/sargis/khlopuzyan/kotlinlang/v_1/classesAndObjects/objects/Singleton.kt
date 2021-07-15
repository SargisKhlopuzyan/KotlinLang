package app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.objects

/**
 * Created by Sargis Khlopuzyan, on 2/14/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * TODO
 * NOTE: object declarations can't be local (i.e. be nested directly inside a function),
 * but they can be nested into other object declarations or non-inner classes.
 * */
fun main() {
    val x = Singleton
    val y = Singleton

    println(x == y)

    Singleton.myFunction()
}

object Singleton : MyClass() {

    var x = 10

    fun myFunction() {

    }
}

open class MyClass {

    class NestedClass {
        object NestedSingleton {}
    }

    inner class InnerClass {
//        object InnerSingleton {} // INFO: TODO Error!! object declarations is not allowed in inner classes.
    }
}


val x = Singleton

fun myFunction() {

//    object LocalSingleton {} // INFO: TODO Error!! Can't be local
}