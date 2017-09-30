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
    val listInt = listOf(1, 2, 3, 4, 5)
    var listStr = listOf("one", "two", "three", "four", "five")

    listInt.forEach { it * 2 /* it +=2 can't assign the value, can print out */ }

    var doubleArrayInt = listInt.map { it * 2 /* can't assign the value */ }

    var boolVal = listInt.any { it>3 }
    boolVal = listInt.none { it>3 }

    var listStr2 = listStr.map { it + "aa" }

    listStr2 = listStr.sortedBy { it.length }

    listStr2 = listStr.filter { it.startsWith("f") }

    listStr2 = listStr2.mapIndexed { index, str -> str + "_index_$index" }
}


