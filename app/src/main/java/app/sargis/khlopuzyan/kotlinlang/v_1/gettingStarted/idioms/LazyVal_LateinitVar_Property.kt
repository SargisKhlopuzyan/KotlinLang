package app.sargis.khlopuzyan.kotlinlang.v_1.gettingStarted.idioms

import java.io.File

/**
 * Created by Sargis Khlopuzyan, on 2/7/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

//    val subClass = SubClass()
    val subClass: SupperClass = SubClass()
//    subClass.lateinitVarProperty = "B"
    println("subClass.lateinitVarProperty: ${subClass.lateinitVarProperty}")
    println("subClass.lazyProperty: ${subClass.lazyProperty}")
    subClass.temp = "ABCDEF"
    println("subClass.lazyProperty: ${subClass.lazyProperty}")


    val files = File("Test").listFiles()
    println(files?.size)
    println(files?.size ?: "emty")

    val array = arrayOf<String>()
    val firstOrNull = array.firstOrNull()
    println(firstOrNull)
}

private class SubClass : SupperClass() {

    init {
        lateinitVarProperty = ""
    }

//    override val lazyProperty: String
//        get() = "SubClass"
}


private open class SupperClass {

    var temp = "abc"

    open lateinit var lateinitVarProperty: String

    open val lazyProperty: String by lazy {
        temp + "123"
    }

}