package basics

val intArr: IntArray = intArrayOf(1, 2, 3)

fun arrayTest() {
    intArr[0] = intArr[1] + intArr[2]
}

fun someCollections(){
    val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
    val readOnlyView: List<Int> = numbers
    println(numbers)        // prints "[1, 2, 3]"
    numbers.add(4)
    println(readOnlyView)   // prints "[1, 2, 3, 4]"
//    readOnlyView.clear()    // -> does not compile

    val strings = hashSetOf("a", "b", "c", "c")
    assert(strings.size == 3)
}

