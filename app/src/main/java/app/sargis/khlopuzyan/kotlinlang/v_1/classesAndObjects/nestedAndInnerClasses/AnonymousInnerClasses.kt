package app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.nestedAndInnerClasses

import app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.nestedAndInnerClasses.java.JavaFunctionalInterface


/**
 * Created by Sargis Khlopuzyan, on 2/13/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

    val myAbstract = object : MyAbstract() {
        override fun abstractFunction() {

        }

        /** OK **/
//        override fun abstractNormalFunction() {
//            abstractCompanionFunction()
//        }

    }

    val myInterface = object : MyInterface {
        override fun interfaceFunction() {

        }

        /** OK **/
//        override fun interfaceDefaultFunction() {
//            interfaceCompanionFunction()
//        }
    }

    /**
     * Note: on the JVM, if the object is an instance of a functional Java interface
     * (i.e. a Java interface with a single abstract method), you can create it
     * using a lambda expression prefixed with the type of the interface:
     * */
    val listenerJava =
        _root_ide_package_.app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.nestedAndInnerClasses.java.JavaFunctionalInterface {

        }

    // !! Error
//    val listenerKotlin = KotlinFunctionalInterface {
//
//    }
}

abstract class MyAbstract {

    open fun abstractNormalFunction() {}

    abstract fun abstractFunction()

    companion object {
        fun abstractCompanionFunction() {}
    }
}

interface MyInterface {

    fun interfaceFunction()

    fun interfaceDefaultFunction() {}

    companion object {
        fun interfaceCompanionFunction() {}
    }
}

interface KotlinFunctionalInterface {
    fun myFunctionalInterfaceFunction(): Int
}