package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.delegatedProperties

import kotlin.reflect.KProperty

/**
 * Created by Sargis Khlopuzyan, on 2/17/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */
class C {
    var prop: String by MyDelegate()
}

/**
 * This code is generated by the compiler instead:
 * */

fun main() {
    val c = C()
    println(c.prop)
    c.prop = "12345"
    println(c.prop)
}


class C_Translated {

    // X = $
    private val propXdelegate = MyDelegate()

    var prop: String
        get() = propXdelegate.getValue(this, this::prop)
        set(value: String) = propXdelegate.setValue(this, this::prop, value)

}

class MyDelegate {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, property: ${property.name}"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef -> $value has been assigned to ${property.name}")
    }
}