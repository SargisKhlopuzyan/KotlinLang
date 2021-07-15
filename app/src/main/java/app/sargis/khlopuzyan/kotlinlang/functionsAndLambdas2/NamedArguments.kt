package app.sargis.khlopuzyan.kotlinlang.functionsAndLambdas2

/**
 * Created by Sargis Khlopuzyan, on 8/19/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {
    reformat("STR", wordSeparator = 'c', str3 = "STR3", str2 = "STR2")

    /**
     * You can skip some arguments with default values. However, after the first skipped argument, you must name all subsequent arguments:
     * */
    reformat("STR", true, true, "STR2", wordSeparator = 'c', str3 = "STR3")
}

fun reformat(
    str: String,
    normalizeCase: Boolean = true,
    upperCaseFirstLetter: Boolean = true,
    str2: String,
    divideByCamelHumps: Boolean = false,
    wordSeparator: Char = ' ',
    str3: String
) {
    /*...*/
}