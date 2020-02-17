package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.delegatedProperties

import kotlin.reflect.KProperty

/**
 * Created by Sargis Khlopuzyan, on 2/17/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

/**
 * For a mutable property (a var), a delegate has to additionally provide a function named setValue that takes the following parameters:
 *
 * thisRef — same as for getValue();
 * property — same as for getValue();
 * new value — must be of the same type as the property or its subtype.
 * getValue() and/or setValue() functions may be provided either as member functions of the delegate class or extension functions.
 * The latter is handy when you need to delegate property to an object which doesn't originally provide these functions.
 * Both of the functions need to be marked with the operator keyword.
 *
 * The delegate class may implement one of the interfaces ReadOnlyProperty and ReadWriteProperty containing the required operator methods.
 * These interfaces are declared in the Kotlin standard library:
 * */

interface ReadOnlyProperty<in R, out T> {
    operator fun getValue(thisRef: R, property: KProperty<*>): T
}

interface ReadWriteProperty<in R, T> {
    operator fun getValue(thisRef: R, property: KProperty<*>): T
    operator fun setValue(thisRef: R, property: KProperty<*>, value: T)
}