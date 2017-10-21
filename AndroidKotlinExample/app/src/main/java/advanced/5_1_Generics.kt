package advanced

class TypedClass<T>(param: T) {
    val value: T = param
}

fun <K, V, R, T> genericFun(param1: K, param2: V, param3: R, param4: T) {/*body*/}


class LimitedClass<T : Context>(param: T)
// limit to Context and subclasses implementing/extending it
// LimitedClass(activity)
// LimitedClass(service)
// LimitedClass(context)