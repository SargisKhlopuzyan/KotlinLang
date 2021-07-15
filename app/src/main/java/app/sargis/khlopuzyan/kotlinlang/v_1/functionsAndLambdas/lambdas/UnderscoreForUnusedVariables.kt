package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas.lambdas

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * Created by Sargis Khlopuzyan, on 2/21/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * INFO-TODO
 * If the lambda parameter is unused, you can place an underscore instead of its name:
 * */

@RequiresApi(Build.VERSION_CODES.N)
fun main() {

    val list = listOf("1", "a", "2", "b", "3", "4", "5")
    list.forEachIndexed { _, element ->
        println("element: $element")
    }
    // Or
    val map = mapOf((1 to "a"), (2 to "b"))
    map.forEach { _, value ->
        println("$value!")
    }
}
