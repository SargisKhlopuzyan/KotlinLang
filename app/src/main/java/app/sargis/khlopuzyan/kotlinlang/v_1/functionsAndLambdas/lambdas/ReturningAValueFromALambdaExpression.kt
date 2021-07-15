package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas.lambdas

/**
 * Created by Sargis Khlopuzyan, on 2/21/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    val myList = MyList()
    val resultList = myList.funFilter { it.length == 2 }.funSortedBy { it }.funMap { it }
    println("resultList: ${resultList.list}")


    /**
     * We can explicitly return a value from the lambda using the qualified return syntax. Otherwise,
     * the value of the last expression is implicitly returned.
     *
     * Therefore, the two following snippets are equivalent:
     * */
    val ints = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    val result1 = ints.filter {
        val shouldFilter = it > 5
        shouldFilter
    }
    println("result1: $result1")

    val result2 = ints.filter {
        val shouldFilter = it > 5
        return@filter shouldFilter
    }
    println("result2: $result2")

    // This convention, along with passing a lambda expression outside parentheses, allows for LINQ-style code:
    val result3 = ints.filter { it > 5 }.sortedBy { it }.map { it.toFloat() }
    println("result3: $result3")
}


class MyList {

    constructor()

    constructor(_list: MutableList<String>) {
        list = _list
    }

    var list = listOf("a", "bcd", "cd", "de", "efghi", "fg")

    fun funFilter(myLambda: (String) -> Boolean): MyList {

        val _list = mutableListOf<String>()

        for (e in list) {
            if (myLambda(e)) {
                _list.add(e)
            }
        }

        return MyList(_list)
    }

    fun funSortedBy(myLambda: (String) -> String): MyList {
        val _list = list.sortedBy { it }.toMutableList()
        return MyList(_list)
    }

    fun funMap(myLambda: (String) -> String): MyList {

        val _list = mutableListOf<String>()

        for (e in list) {
            _list.add(myLambda(e))
        }

        return MyList(_list)
    }

}