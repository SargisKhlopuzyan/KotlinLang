package app.sargis.khlopuzyan.kotlinlang.v_1.functionsAndLambdas.lambdas

fun main() {

    val lambdaExpressionResult = lambdaExpression(5, 6)
    println("lambdaExpressionResult: $lambdaExpressionResult")

    val anonymousFunctionResult = anonymousFunction(5, 6)
    println("anonymousFunctionResult: $anonymousFunctionResult")

    //********************************************************

    mainFunction1()
    mainFunction2()
    mainFunction3()
    mainFunction4()
    //********************************************************

    val functionTypeResult = functionType(5, 6)
    println("functionResult: $functionTypeResult")
}

/**
 * INFO-IMPORTANT-TODO
 * There are several ways to obtain an instance of a function type:
 *
 * 1:
 * - Using a code block within a function literal, in one of the forms:
 *   - a lambda expression: { a, b -> a + b },
 *   - an anonymous function: fun(s: String): Int { return s.toIntOrNull() ?: 0 }
 * */
//********************************************************

val lambdaExpression = { a: Int, b: Int -> a + b }

val anonymousFunction = fun(a: Int, b: Int): String {
    return (a + b).toString()
}

//********************************************************

/**
 * INFO-IMPORTANT-TODO
 *
 * 2:
 * - Using a callable reference to an existing declaration:
 *   - a top-level, local, member, or extension function: ::isOdd, String::toInt,
 *   - a top-level, member, or extension property: List<Int>::size,
 *   - a constructor: ::Regex
 * These include bound callable references that point to a member of a particular instance: foo::toString.
 * */

//a top-level function
fun functionIsOdd(value: Int): Boolean {
    return value % 2 == 0
}

//extension function
fun String.convertToInt(): Int {
    return this.toInt()
}

class MyClass {

    var memberProperty = 6789

    //member function
    fun myMemberFunction(value: Int): String {

        //local function
        fun myLocalFunction(value: Int): String = value.toString()

        //TODO Appendix *LocalFunction_1
        val localFunction = ::myLocalFunction
        val stringValueLocalFunction = localFunction(987654321)
        println("local function -> $stringValueLocalFunction")
        //End of Appendix *LocalFunction_1

        return value.toString()
    }

}

class MyClassWithConstructor {

    var memberProperty = 111111

    constructor(x: Int) {
        memberProperty = x
    }

    fun myFunction() {}

}

// a top-level, local, member, or extension function: ::isOdd, String::toInt,
fun mainFunction1() {

    //a top-level function
    val funIssOdd = ::functionIsOdd
    val isOddResult = funIssOdd(552)
    println("top-level function -> isOddResult: $isOddResult")

    //extension function
    val extensionFunction = String::convertToInt
    val intValueExtensionFunction = extensionFunction("123456789")
    println("extension function -> $intValueExtensionFunction")

    //member function
    val myClass = MyClass()
    val memberFunction = myClass::myMemberFunction
    val stringValueMemberFunction = memberFunction(123456789)
    println("member function -> $stringValueMemberFunction")

    //local function
    //TODO See in appendix *LocalFunction_1
}


// a top-level, member, or extension property: List<Int>::size,
fun mainFunction2() {

    // top-level property
    println("$topLevelProperty")
    ::topLevelProperty.set(15)
    println("$topLevelProperty")
    //or
    val x = ::topLevelProperty.get()
    println("$x")

    //**********************************************************************************

    // member property
    val myClass = MyClass()
    println(myClass::memberProperty.get())
    myClass::memberProperty.set(12)
    println(myClass::memberProperty.get())

    //WARNING : property memberProperty (Kotlin reflection is not available)
//    println(myClass::memberProperty)

    //**********************************************************************************

    //IMPORTANT - version 1 OR version 2 - TODO

    // extension property version 1
    println(MyClass::extensionProperty.get(myClass))
    MyClass::extensionProperty.set(myClass, "It's a changed extension property")
    println(MyClass::extensionProperty.get(myClass))

    //WARNING - property extensionProperty (Kotlin reflection is not available)
//    println(MyClass::extensionProperty)

    //**********************************************************************************

    // extension property version 2
    // These include bound callable references that point to a member of a particular instance: foo::toString.
    println(myClass::extensionProperty.get())
    myClass::extensionProperty.set("It's a changed extension property")
    println(myClass::extensionProperty.get())

    //WARNING - property extensionProperty (Kotlin reflection is not available)
//    println(myClass::extensionProperty)
}


var topLevelProperty = 12345

private var _extensionProperty: String = "It's an extension property"

var MyClass.extensionProperty: String
    get() = _extensionProperty
    set(value) {
        _extensionProperty = value
    }

//********************************************************

//a constructor: ::Regex
fun mainFunction3() {
    val myClassWithConstructor = ::MyClassWithConstructor
    println(myClassWithConstructor(5555))
}

//********************************************************

/**
 * INFO-IMPORTANT-TODO
 * Using instances of a custom class that implements a function type as an interface:
 */

class IntTransformer : (Int) -> String {
    override operator fun invoke(x: Int): String = x.toString()
}

class IntTransformer2 : (Int, Int) -> String {

    override fun invoke(p1: Int, p2: Int): String {
        return (p1 + p2).toString()
    }
}


fun mainFunction4() {
    val intTransformer: (Int) -> String = IntTransformer()
    val intTransformer2 = IntTransformer()

    println(intTransformer(4444))
    println(intTransformer2(22))

    val x = aFunction(5)
    println("x: $x")

    println("result: $result")
}

//********************************************************

//INFO-TODO
//The compiler can infer the function types for variables if there is enough information:
val aFunction = { i: Int -> i + 1 } // The inferred type is (Int) -> Int

//********************************************************

/**
 * INFO-TODO
 * Non-literal values of function types with and without receiver are interchangeable,
 * so that the receiver can stand in for the first parameter, and vice versa.
 * For instance, a value of type (A, B) -> C can be passed or assigned where a A.(B) -> C is expected and the other way around:
 * */

val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
val twoParameters: (String, Int) -> String = repeatFun // OK

fun runTransformation(f: (String, Int) -> String): String {
    return f("hello", 3)
}
val result = runTransformation(repeatFun) // OK


// Note that a function type with no receiver is inferred by default, even if a variable is initialized with a reference to an extension function.
// To alter that, specify the variable type explicitly.

//********************************************************

val functionType: (Int, Int) -> (String) = { x, y ->
    (x * y).toString()
}