package basics

import intermediate.isOdd

fun ifElse() {
    val a = 2
    val b = 3

    // no more '<condition> ? <if-true> : <else>
    val min = if (a < b) a else b

    val max = if (a > b) {
        print("Choose a")
        a // last sentence is a return value
    } else {
        print("Choose b")
        b // last sentence is a return value
    }
}

fun forLoop() {
    val ints: IntArray = intArrayOf(1, 2, 3)
    for (item in ints) { /*body*/ }
}

fun whileLoop() {
    var a = 5
    while (a > 0) {
        //
        a--
    }

    do {
        var i = 5
        /*body*/
    } while(i-- <= 0)
}

fun veryBasicSwitchCase(value: Int){
    when(value){
        0 -> print("0")
        1 -> print("1")
        else -> print("unknown")
    }
}

