package app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.delegatedProperties

import kotlin.reflect.KProperty

fun main() {
    val e = Example1()
    println(e.p)
    e.p = "OK"
}

class Example1 {
    var p: String by Delegate1()
}

class Delegate1 {

//    operator fun getValue(thisRef: Example, property: KProperty<*>): String {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
//    operator fun setValue(thisRef: Example, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")

    }

}