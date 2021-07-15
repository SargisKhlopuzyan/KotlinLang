package app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.objects

/**
 * Created by Sargis Khlopuzyan, on 2/14/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * INFO-TODO
 * Note that, even though the members of companion objects look like static members in other languages,
 * at runtime those are still instance members of real objects, and can, for example, implement interfaces:
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * However, on the JVM you can have members of companion objects generated as real static methods and fields,
 * if you use the @JvmStatic annotation. See the Java interoperability section for more details.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * Semantic difference between object expressions and declarations
 * There is one important semantic difference between object expressions and object declarations:
 *
 * - object expressions are executed (and initialized) immediately, where they are used;
 * - object declarations are initialized lazily, when accessed for the first time;
 * - a companion object is initialized when the corresponding class is loaded (resolved), matching the semantics of a Java static initializer.
 *
 * */
fun main() {
    val instance2 = MyClass2.create()

    /**
     * INFO-TODO
     * The name of a class used by itself (not as a qualifier to another name)
     * acts as a reference to the companion object of the class (whether named or not):
     * */
    val companion2 = MyClass3.Companion
    val companion3 = MyClass3
    println(companion2)

    MyClass4.MyClass4CompanionObject.myClass5Function()
    MyClass4.MyClass4CompanionObject.args
//    MyClass4.MyClass4CompanionObject.MyClass5CompanionObject.x
}

class MyClass2 {

    companion object Factory {
        fun create(): MyClass2 = MyClass2()
    }

}

class MyClass3 {

    companion object {
        fun create(): MyClass3 = MyClass3()
    }

}

// TODO IMPORTANT *******************************************************************************
class MyClass4 {

    companion object MyClass4CompanionObject : MyClass5(), Factory<MyClass4>, Factory2<MyClass4> {

        override fun create(): MyClass4 = MyClass4()

        override fun create2(): MyClass4 = MyClass4()

        override fun myClass5Function() {

        }
    }
}

open class MyClass5 {

    val args = 123

    open fun myClass5Function() {}

    companion object MyClass5CompanionObject {
        var x = 123456789
    }

}

interface Factory<T> {
    fun create(): T
}

interface Factory2<T> {
    fun create2(): T
}