package app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.visibilityModifiers

/**
 * Created by Sargis Khlopuzyan, on 2/11/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

}

open class Outer {

    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4

    protected class Nested {
        public val e = 5

        fun myFuntcion() {
//            a
//            b
//            c
//            d

            e
        }
    }

    protected inner class Inner {
        public val f = 5

        fun myFuntcion() {
            a
            b
            c
            d

            f
        }
    }
}

class Subclass : Outer() {

    override val b: Int
        get() = 22

    fun myFuntion() {
//        a
        b
        c
        d
    }

}

class Unrelated(var o: Outer) {

    fun myFuntion() {
        o.c
        o.d
    }

}