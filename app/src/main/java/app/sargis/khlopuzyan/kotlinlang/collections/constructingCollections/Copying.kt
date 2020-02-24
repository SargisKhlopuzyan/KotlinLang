package app.sargis.khlopuzyan.kotlinlang.collections.constructingCollections

/**
 * Created by Sargis Khlopuzyan, on 2/24/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

    /**
     * Collection copying functions, such as toList(), toMutableList(), toSet() and others,
     * create a snapshot of a collection at a specific moment.
     * Their result is a new collection of the same elements.
     * If you add or remove elements from the original collection, this won't affect the copies.
     * Copies may be changed independently of the source as well
     * */
    val sourceList = mutableListOf(1, 2, 3)
    val copyList = sourceList.toMutableList()
    val readOnlyCopyList = sourceList.toList()
    sourceList.add(4)
    println("Copy size: ${copyList.size}") //Copy size: 3

    //readOnlyCopyList.add(4)             // compilation error
    println("Read-only copy size: ${readOnlyCopyList.size}")

    // These functions can also be used for converting collections to other types, for example, build a set from a list or vice versa.
    val copySet = sourceList.toMutableSet()
    copySet.add(3)
    copySet.add(4)
    println(copySet)

    /**
     * Collection initialization can be used for restricting mutability.
     * For example, if you create a List reference to a MutableList,
     * the compiler will produce errors if you try to modify the collection through this reference.
     * */
    val referenceList: List<Int> = sourceList
//    referenceList.add(4)            //compilation error
    sourceList.add(4)
    println(referenceList) // shows the current state of sourceList
}