package app.sargis.khlopuzyan.kotlinlang.v_1.classesAndObjects.extensions

/**
 * Created by Sargis Khlopuzyan, on 2/11/2020.
 *
 * @author Sargis Khlopuzyan (sargis.khlopuzyan@fcc.am)
 */

fun main() {

    val host = Host("www.12.5.52.125")
    val connection = Connection(host = host, port = 8080)

    connection.connect()
//    connection.printConnectionString()
}

/**
 * extension receiver
 * */
class Host(val hostname: String) {
    fun printHostname() {
        print(hostname)
    }
}

/**
 * dispatch receiver
 * */
class Connection(val host: Host, val port: Int) {

    /**
     * In case of a name conflict between the members of the dispatch receiver
     * and the extension receiver, the extension receiver takes precedence.
     * To refer to the member of the dispatch receiver you can use the
     * */
    fun printHostname() {
        print("Connection -> PrintHostname")
    }

    fun printPort() {
        print(port)
    }

    fun connect() {
        host.printConnectionString()
    }

    fun Host.printConnectionString() {
        printHostname() // This will call extension function
        this@Connection.printHostname()
        print(":")
        printPort()
    }

}