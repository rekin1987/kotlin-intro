package basics

val intArr: IntArray = intArrayOf(1, 2, 3)

fun arrayTest() {
    intArr[0] = intArr[1] + intArr[2]
}

val list = mutableListOf("one", "five", "ten")

fun listUsingExtensionFunctions() {
    val fiveStr = list[1] // thanks to extension functions
    list += "twenty" // add item (only for mutable list)
}

fun iterateOverList(){
    for (str in list){
        println(str)
    }
    // better alternative - using lambda
    list.forEach { println(it) }
}