package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.objects

/**
 * Created by Sargis Khlopuzyan, on 2/14/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */
fun main() {

    val obj = object : ObjectExpressions(123456), MyInterface {

        override var argVar = 321
//        override val argVal = 123 // Error

        fun myFunction3() {

        }

        override fun myFunction4() {

        }
    }

    obj.myFunction1()
    obj.myFunction2()
    obj.myFunction3()
}

open class ObjectExpressions constructor(x: Int) {

    open var argVar = 123
    open var argVal = 123

    fun myFunction1() {

    }

    fun myFunction2() {

    }
}

interface MyInterface {
     fun myFunction4()
}