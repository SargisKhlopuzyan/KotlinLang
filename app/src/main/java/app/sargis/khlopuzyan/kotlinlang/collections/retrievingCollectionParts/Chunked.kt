package app.sargis.khlopuzyan.kotlinlang.collections.retrievingCollectionParts

/**
 * Created by Sargis Khlopuzyan, on 3/10/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * Chunked
 *
 * To break a collection onto parts of a given size, use the chunked() function. chunked() takes a single
 * argument – the size of the chunk – and returns a List of Lists of the given size.
 * The first chunk starts from the first element and contains the size elements,
 * the second chunk holds the next size elements, and so on. The last chunk may have a smaller size.
 * */
fun main() {
    val numbers = (0..13).toList()
    println(numbers.chunked(3)) // [[0, 1, 2], [3, 4, 5], [6, 7, 8], [9, 10, 11], [12, 13]]

    /**
     * You can also apply a transformation for the returned chunks right away.
     * To do this, provide the transformation as a lambda function when calling chunked().
     * The lambda argument is a chunk of the collection. When chunked() is called with a transformation,
     * the chunks are short-living Lists that should be consumed right in that lambda.
     * */
    println(numbers.chunked(3) { it.sum() }) // [3, 12, 21, 30, 25]
}