package intermediate

// aggregate operations:
// any, all, none, count, forEach, forEachIndexed, max, min

// filtering operations
// drop, dropWhile, filter, slice, take, takeLast, takeWhile

// mapping operations
// flatMap, groupBy, map, mapIndexed

// elements operations
// contains, elementAt, first, last, indexOf

// generation operations
// merge, partition, plus

// ordering operations
// reverse, sort, sortBy, sortDescending, sortDescendingBy


fun collections1() {
    val arrayInt = listOf(1, 2, 3, 4, 5)
    var arrayStr = listOf("one", "two", "three", "four", "five")

    arrayInt.forEach { it * 2 /* it +=2 can't assign the value, can print out */ }
    var doubleArrayInt = arrayInt.map { it * 2 /* can't assign the value */ }

    var boolVal = arrayInt.any { it>3 }
    boolVal = arrayInt.none { it>3 }

    var arrayStr2 = arrayStr.map { it + "aa" }

    arrayStr2.forEach { println(it) }

    arrayStr2 = arrayStr.sortedBy { it.length }

    arrayStr2.forEach { println(it) }

    arrayStr2 = arrayStr.filter { it.startsWith("f") }

    arrayStr2.forEach { println(it) }

}

fun collections2(){
    val list = listOf("one", "two", "three", "four", "five")
    var list2 = list.map { it + "aa" }

    list2 = list.mapIndexed { index: Int, s: String ->  s + "_index_$index" }
    list2 = list.mapIndexed { index, str -> str + "_index_$index" }

}

