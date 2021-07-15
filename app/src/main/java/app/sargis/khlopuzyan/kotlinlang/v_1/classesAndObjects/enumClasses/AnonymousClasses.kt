package app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.enumClasses

/**
 * Created by Sargis Khlopuzyan, on 2/13/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

    val talking = ProtocolState.TALKING
    val waiting = ProtocolState.WAITING
    println(waiting.printArg()) // 0
    println(talking.printArg()) // 1111
    println(waiting.printArg()) // 0

    println(talking.name)

}

enum class ProtocolState {

    WAITING {
        override fun signal() = WAITING

        override fun printArg(): Int {
            return arg
        }
    },

    TALKING {
        override fun signal() = TALKING

        override fun printArg(): Int {
            arg = 1111
            return arg
        }
    };

    //*******************

    var arg = 0

    abstract fun signal(): ProtocolState

    open fun printArg(): Int {
        return arg
    }

    companion object {
        val compObj = 12
    }

    inner class MyInnerClass () {

    }

    //*******************

}