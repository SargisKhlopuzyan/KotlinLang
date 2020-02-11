package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.classesAndInheritance

/**
 * Created by Sargis Khlopuzyan, on 2/11/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

open class Rectangle1 {
    open fun draw() { /* ... */ }
}

interface Polygon1 {
    fun draw() { /* ... */ } // interface members are 'open' by default
}

class Square() : Rectangle1(), Polygon1 {
    // The compiler requires draw() to be overridden:
    override fun draw() {
        super<Rectangle1>.draw() // call to Rectangle.draw()
        super<Polygon1>.draw() // call to Polygon.draw()
    }
}