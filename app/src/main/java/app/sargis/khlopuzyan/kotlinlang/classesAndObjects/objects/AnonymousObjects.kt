package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.objects

/**
 * Created by Sargis Khlopuzyan, on 2/14/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */
class AnonymousObjects


/**
 * Note that anonymous objects can be used as types only in local and private declarations.
 * If you use an anonymous object as a return type of a public function or the type of a public property,
 * the actual type of that function or property will be the declared supertype of the anonymous object,
 * or Any if you didn't declare any supertype. Members added in the anonymous object will not be accessible.
 * */

fun main() {
    println(adHoc)

    val privateFooObject = privateFoo()
    val publicFooObject = publicFoo()

    privateFooObject.myFunction() // Works
//    publicFooObject.myFunction() // ERROR: Unresolved reference 'x'
}


val adHoc = object {
    var x: Int = 0
    var y: Int = 0
}

// INFO TODO Public function, so the return type is Any
fun publicFoo() = object {

    var x: Int = 10

    fun myFunction() {

    }
}

// INFO TODO Private function, so the return type is the anonymous object type
private fun privateFoo() = object {

    var x: Int = 10

    fun myFunction() {

    }
}