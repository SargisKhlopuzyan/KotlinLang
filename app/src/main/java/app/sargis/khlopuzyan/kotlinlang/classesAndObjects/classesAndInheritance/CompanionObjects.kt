package app.sargis.khlopuzyan.kotlinlang.classesAndObjects.classesAndInheritance

/**
 * Created by Sargis Khlopuzyan, on 2/11/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

private var TEST = "TEST"

class CompanionObjects {

    companion object {

        fun companionObjectFunction() {
            TEST = ""
        }

    }

}