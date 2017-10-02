package advanced



// covariance - storing a subtype in a super/parent type
class SpecialCollection<out T> {
    fun nextT(): T { return 1 as T}
}
val s1: SpecialCollection<String> = SpecialCollection()
val s2: SpecialCollection<Any> = s1 // This is OK, since T is an out-parameter


// contravariance - storing a super/parent type in a subtype
class TypeComparator<in T> {
    fun compare(param: T){}
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
    val any = Array<Any>(3) { "" }
    copy(ints, any) // This is OK, copy() mark 'from' Array as an out-parameter
}