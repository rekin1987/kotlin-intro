package intermediate

fun forWithRanges() {
    for (i in 0..10) {/*body*/
    }
    for (i in 0..10 step 2) {/*body*/
    }
    for (i in 15 downTo 0 step 3) {/*body*/
    }
}

fun whenExpr(x: Any) {
    // works like switch, but more extended
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        in 3..9 -> print("x between 3 and 9") // range
        is String -> print("input is String type")
        is Int -> if (x.isOdd()) print("x is odd") else print("x is even")
        else -> { // Note the block
            print("x is weird")
        }
    }
}

fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }