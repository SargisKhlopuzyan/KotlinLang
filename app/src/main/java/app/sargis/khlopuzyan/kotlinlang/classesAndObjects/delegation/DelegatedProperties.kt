package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.delegation

import kotlin.reflect.KProperty

/**
 * Created by Sargis Khlopuzyan, on 2/17/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    val e = Example()
    println(e.p)
    e.p = "NEW"
}

class Example {
    var p: String by Delegate()
}

class Delegate {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }

}