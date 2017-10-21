package advanced


// covariance - storing a subtype in a super/parent type
// can be interpreted as producer - only producing value
class SpecialCollection<out T> {
    fun nextT(): T {
        return 1 as T
    }

//    fun aFun(aa: T) {} // error, T is defined as 'out' but here occurs as 'in'
}

val s1: SpecialCollection<String> = SpecialCollection()
val s2: SpecialCollection<Any> = s1 // This is OK, since T is an out-parameter


// contravariance - storing a super/parent type in a subtype
// can be interpreted as consumer - only expects value, never returns it
class TypeComparator<in T> {
    fun compare(param: T) {}
//    fun giveObj(): T { // error, T is defined as 'in' but here occurs as 'out'
//        return 1 as T
//    }
}

val d1: TypeComparator<Any> = TypeComparator()
val d2: TypeComparator<String> = d1 // This is OK, since T is an in-parameter


// covariance
fun copy(from: Array<out Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices)
        to[i] = from[i]
}

fun checkCovariance() {
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { /*empty array*/ }
    copy(ints, any) // This is OK, in function copy() 'from' Array is defined as an out-parameter
}