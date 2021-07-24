package app.sargis.khlopuzyan.kotlinlang.v_1_5_20.asynchronousFlow

/**
 * Created by Sargis Khlopuzyan, on 7/24/2021.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fastshift.com)
 */
fun main() {
    simple().forEach { value ->
        println(value)

    }
}

fun simple() : Sequence<Int> = sequence {
    for (i in 1..3) {
        Thread.sleep(2000)
        yield(i) // yield next value
    }
}