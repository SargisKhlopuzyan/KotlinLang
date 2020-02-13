package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.nestedAndInnerClasses

import android.view.View
import android.view.Window
import android.view.WindowManager

/**
 * Created by Sargis Khlopuzyan, on 2/13/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    Outer.Nested().foo()
    Outer2().Inner().foo()
    Outer2().Inner().boo()
    Outer2().Inner().functionThis()
    Outer2().Inner().functionOuterThis()
}

class Outer {

    private val bar: Int = 1

    class Nested {

        fun foo() = 2

//        fun boo() = bar

    }
}

class Outer2 {

    private val bar: Int = 1

    inner class Inner {

        fun foo() = 2

        fun boo() = bar

        fun functionThis() = this

        fun functionOuterThis() = this@Outer2

    }
}