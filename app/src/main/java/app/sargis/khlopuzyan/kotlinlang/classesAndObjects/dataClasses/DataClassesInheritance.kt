package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.dataClasses

/**
 * Created by Sargis Khlopuzyan, on 2/12/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

    val user1 = User("Sargis", 30)
    val user2 = User("Sargis", 30)

    println(user1 == user2)

    val copyUser1_1 = user1.copy()
    val copyUser1_2 = user1.copy(age = 31)

}

data class User(val name: String, val age: Int) : SuperClass(name), MyInterface {

    override var surname: String = "Kh"

    var nationality: String = "RA"

    override fun myFunction() {
    }

    override fun myInterfaceFunction() {
    }

    override fun toString(): String {
        return name
    }

//    fun copy(nameX: String = this.name, ageX: Int = this.age) = User(nameX, ageX)

}

abstract class SuperClass(open val surname: String) {
    abstract fun myFunction()
}

interface MyInterface {
    fun myInterfaceFunction()
}