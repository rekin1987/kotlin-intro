package advanced

class APerson(val name: String, val age: Int, val male: Boolean) {
    operator fun component1() = name // short function syntax - return name
    operator fun component2() = age // short function syntax - return age
    operator fun component3() = male // short function syntax - return male
}

fun destructing1() {
    val person = APerson("abc", 18, true)
    val (pName, pAge, pMale) = person

    pAge == person.age
}

fun returningPerson(): APerson {
    return APerson("abc", 18, true)
}

// simulates returning more than one object
fun testMultipleReturn(){
    val (pName, pAge, pMale) = returningPerson()
}

fun destructing2() {
    val myMap = mapOf(1 to "one", 2 to "two", 3 to "three")
    // same as above
    // val myMap = mapOf(Pair(1, "one"), Pair(2, "two"), Pair(3, "three"))

    for ((k, v) in myMap) {
                    println("key=$k, value=$v")
    }
}

fun destructing3() {
    val ints: IntArray = intArrayOf(1, 2, 3)
    for (item in ints) {
        // ...
    }

    for ((index, value) in ints.withIndex()) {
        println("the element at $index is $value")
    }
}