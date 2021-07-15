package app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects

/**
 * Created by Sargis Khlopuzyan, on 2/11/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

//    TEST = ""

//    setterVisibility = ""

//    MyClass.printCompanion()

    val user1 = User("Sargis", 30)
    val user2 = User("Sargis", 30)

    val copyUser1 = user1.copy()

    println(user1 == user2)

}

abstract class SuperClass(open val surname: String) {
    abstract fun myFunction()
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

interface MyInterface {
    fun myInterfaceFunction()
}