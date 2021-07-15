package app.sargis.khlopuzyan.kotlinlang.v_1.collections.constructingCollections

/**
 * Created by Sargis Khlopuzyan, on 2/24/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */
fun main() {
    /**
     * For lists, there is a constructor that takes the list size and the initializer function that defines the element value based on its index.
     * */
    val doubled = List(3, { it * 2 })  // or MutableList if you want to change its content later
    println(doubled)
}