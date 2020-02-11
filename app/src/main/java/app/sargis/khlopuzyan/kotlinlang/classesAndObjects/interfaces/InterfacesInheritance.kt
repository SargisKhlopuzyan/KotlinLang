package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.interfaces

/**
 * Created by Sargis Khlopuzyan, on 2/11/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

data class Employee(
    override val firstName: String,
    override val lastName: String,
    val position: Int
) : Person

interface Named {
    val name: String
}

interface Person : Named {

    val firstName: String
    val lastName: String

    override val name: String
        get() = "$firstName $lastName"

}