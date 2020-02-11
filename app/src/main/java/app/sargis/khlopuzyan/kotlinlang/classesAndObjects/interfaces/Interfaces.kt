package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.interfaces

/**
 * Created by Sargis Khlopuzyan, on 2/11/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */


class MyClass :
    MyInterface {

    override val propVal: Int
        get() = 12345

    override var propVar: Int
        get() = 123456789
        set(value) {
        }

    override fun bar() {}
}

interface MyInterface {

    val propVal: Int // abstract

    var propVar: Int // abstract

    val accessorsPropVal: String
        get() = "text"
//    or
//        get() = propVal.toString()

    fun bar()

    fun foo() {}
}