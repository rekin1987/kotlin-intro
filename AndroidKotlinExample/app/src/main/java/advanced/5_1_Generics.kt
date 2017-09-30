package advanced

class TypedClass <T>(param: T){
    val value:T = param
}

// limit to Context and subclasses implementing/extending it
// LimitedClass(activity)
// LimitedClass(service)
// LimitedClass(context)
class LimitedClass<T: Context> (param: T)



// variance - covariance and contravariance