package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.dataClasses

/**
 * Created by Sargis Khlopuzyan, on 2/12/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

//    var (name, surname, age) = Person("S", "Kh", 30)
    val person = Person("S", "Kh", 30)
    var (name, surname, age) = person

    println("$name $surname, $age years of age") // prints "Jane, 35 years of age
}

data class Person(val name: String, val surname: String, val age: Int)