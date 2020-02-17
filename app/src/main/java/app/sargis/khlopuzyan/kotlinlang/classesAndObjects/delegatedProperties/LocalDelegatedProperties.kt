package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.delegatedProperties

/**
 * Created by Sargis Khlopuzyan, on 2/17/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    example {
        Foo()
    }
}

fun example(computeFoo: () -> Foo) {

    val someCondition = true
    val memoizeFoo by lazy(computeFoo)

    if (someCondition && memoizeFoo.isValid()) {
        memoizeFoo.doSomething()
    }

}

class Foo {
    fun isValid(): Boolean {
        return true
    }

    fun doSomething() {
        println("Foo -> doSomething")
    }
}