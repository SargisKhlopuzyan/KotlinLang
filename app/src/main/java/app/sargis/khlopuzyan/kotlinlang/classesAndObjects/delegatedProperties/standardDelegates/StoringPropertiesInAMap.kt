package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.delegatedProperties.standardDelegates

/**
 * Created by Sargis Khlopuzyan, on 2/17/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

    val userMap = UserMap(
        mapOf(
            "name" to "John Doe",
            "age" to 25
            ,
            "salary" to 1000000
        )
    )

    println(userMap.name)
    println(userMap.age)
    println(userMap.salary)

    //********************************************

    val userMutableMap = MutableUser(
        mutableMapOf(
            "name" to "John Doe",
            "age" to 25
            ,
            "salary" to 1000000
        )
    )

    println(userMutableMap.name)
    println(userMutableMap.age)
    println(userMutableMap.salary)
}

/**
 * INFO-TODO
 * for "Map" only "val" is correct ("var" is wrong!!)
 * */
class UserMap(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
    val salary: Int by map
//    var surname: String by map // Wrong!!
}

/**
 * INFO-TODO
 * This works also for var’s properties if you use a MutableMap instead of read-only Map:
 * */
class MutableUser(val mutableMap: MutableMap<String, Any?>) {
    var name: String by mutableMap
    var age: Int by mutableMap
    val salary: Int by mutableMap
}