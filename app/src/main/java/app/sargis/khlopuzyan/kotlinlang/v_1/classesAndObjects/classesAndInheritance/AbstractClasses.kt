package app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.classesAndInheritance

/**
 * Created by Sargis Khlopuzyan, on 2/11/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

open class Polygon2 {
    open fun draw() {}
}

abstract class Rectangle2 : Polygon2() {
    abstract override fun draw()
}