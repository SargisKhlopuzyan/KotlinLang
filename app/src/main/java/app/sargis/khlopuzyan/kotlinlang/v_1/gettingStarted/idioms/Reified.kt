package app.sargis.khlopuzyan.kotlinlang.v_1.gettingStarted.idioms

/**
 * Created by Sargis Khlopuzyan, on 2/7/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

    val gson = Gson()
    val jsonElement = JsonElement()
    val jsonElement2: JsonElement = gson.fromJson(jsonElement)
    println(jsonElement)
    println(jsonElement2)
}

class Gson {

    fun <T> fromJson(json: JsonElement, classOfT: Class<T>): T {
        return classOfT.newInstance()
    }
}

inline fun <reified T : Any> Gson.fromJson(json: JsonElement): T =
    this.fromJson(json, T::class.java)

class JsonElement