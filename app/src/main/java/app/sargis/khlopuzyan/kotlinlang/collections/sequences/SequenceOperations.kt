package app.sargis.khlopuzyan.kotlinlang.collections.sequences

/**
 * Created by Sargis Khlopuzyan, on 2/24/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * INFO-TODO
 *
 * Sequence operations
 * The sequence operations can be classified into the following groups regarding their state requirements:
 *
 * - Stateless operations require no state and process each element independently, for example, map() or filter().
 *
 * - Stateless operations can also require a small constant amount of state to process an element, for example, take() or drop().
 *   Stateful operations require a significant amount of state, usually proportional to the number of elements in a sequence.
 * */

/**
 *   If a sequence operation returns another sequence, which is produced lazily, it's called intermediate.
 *   Otherwise, the operation is terminal. Examples of terminal operations are toList() or sum().
 *   Sequence elements can be retrieved only with terminal operations.
 *
 *   Sequences can be iterated multiple times; however some sequence implementations might constrain themselves to be iterated only once.
 *   That is mentioned specifically in their documentation.
 * */