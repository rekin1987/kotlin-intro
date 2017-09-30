package intermediate

import java.io.File
import java.io.IOException

// no checked exceptions!
// try is expression - can be on the right side of the sentence

fun tryCatch() {

    try {
        //
    } catch (e: IOException) {
        //
    } finally {
        //
    }

    val number = try {
        // parse number
        val numAsString = "5"
        numAsString.toInt()
    } catch (e: NumberFormatException) {
        -1
    }
}