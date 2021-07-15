package app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.propertiesAndFields

/**
 * Created by Sargis Khlopuzyan, on 2/11/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

    val myTest = MyTest()
    myTest.setup()
    myTest.test()

//    if (myTest::subject.isInitialized) {}

}


const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"

@Deprecated(SUBSYSTEM_DEPRECATED)
fun foo() { /*...*/
}

//*********************************************************************

class MyTest {

    private lateinit var subject: TestSubject

    fun setup() {
        subject = TestSubject()
    }

    fun test() {
        if (isInitialized()) {
            subject.method()  // dereference directly
        }
    }

    fun isInitialized() = true //TODO ::subject.isInitialized
}

class TestSubject {
    fun method() {}
}