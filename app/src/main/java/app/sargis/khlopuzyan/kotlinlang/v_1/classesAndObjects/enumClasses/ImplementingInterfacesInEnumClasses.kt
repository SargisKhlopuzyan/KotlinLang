package app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.enumClasses

/**
 * Created by Sargis Khlopuzyan, on 2/13/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    val plus: IntArithmetic = IntArithmetic.valueOf("PLUS")
    val enumsArray: Array<IntArithmetic> = IntArithmetic.values()

    println("plus: $plus")
    println("enumsArray: ${enumsArray.toList()}")

    // TODO
    printAllValues<RGB>() // prints RED, GREEN, BLUE
}


enum class IntArithmetic : MyInterface1<Int>, MyInterface2<String>, MyInterface3<String> {

    PLUS {
        override fun myInterfaceFunction1(t: Int) {

        }

        override fun myInterfaceFunction2(t1: String, t2: String) {
        }

    },

    TIMES {
        override fun myInterfaceFunction1(t: Int) {

        }

        override fun myInterfaceFunction2(t1: String, t2: String) {
        }
    };


    //TODO Important
    override fun myInterfaceFunction3(t1: String, t2: String, t3: String) {
    }

}

interface MyInterface1<T> {
    fun myInterfaceFunction1(t: T)
}

interface MyInterface2<T> {
    fun myInterfaceFunction2(t1: T, t2: T)
}

interface MyInterface3<T> {
    fun myInterfaceFunction3(t1: T, t2: T, t3: T)
}


// TODO - https://kotlinlang.org/docs/reference/enum-classes.html
// TODO - Working with Enum Constants
enum class RGB { RED, GREEN, BLUE }

inline fun <reified T : Enum<T>> printAllValues() {

    print(enumValues<T>().joinToString { it.name })

}