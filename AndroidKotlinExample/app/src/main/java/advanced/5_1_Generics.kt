package advanced

class TypedClass <T>(param: T){
    val value:T = param
}

fun <K> genericFun(param: K) {/*body*/}

// limit to Context and subclasses implementing/extending it
// LimitedClass(activity)
// LimitedClass(service)
// LimitedClass(context)
class LimitedClass<T: Context> (param: T)
