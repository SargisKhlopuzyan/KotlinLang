package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.delegation.standardDelegates

import kotlin.properties.Delegates

/**
 * Created by Sargis Khlopuzyan, on 2/17/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    val user = User()
    user.name = "first"
    user.name = "second"
    user.name = "third"

    user.surname = "_first"
    println(user.surname)
    user.surname = "<_second"
    println(user.surname)
    user.surname = "_third"
    println(user.surname)
}

class User {
    var name: String by Delegates.observable("<no name>") { property, oldValue, newValue ->
        println("property: $property,  $oldValue -> $newValue")
    }

    var surname: String by Delegates.vetoable("<no name>") { k, x: String, y: String ->
        x.startsWith(y[0])
    }
}