package basics

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