package app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.interfaces

/**
 * Created by Sargis Khlopuzyan, on 2/11/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

class D : A, B {

    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
//        super<A>.bar()
        super<B>.bar() // The same // super.bar()
    }

}

class C : A {
    override fun bar() { print("bar") }
}

interface A {
    fun foo() { print("A") }
    fun bar()
}

interface B {
    fun foo() { print("B") }
    fun bar() { print("bar") }
}