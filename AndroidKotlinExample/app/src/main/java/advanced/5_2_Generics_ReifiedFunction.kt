package advanced

sealed class Activity
class AnyActivity : Activity()
open class Context {
    fun <T> startActivity(intent: Intent<T>){ /*body*/ }
}
class Intent <T> (context: Context, clazz: Class<T>){
    fun putExtra(key: String, value: String){ /*body*/ }
}

fun <K> genericFun11(param: K) {/*body*/}

inline fun <reified K> genericFun22(param: K) {
    K::class.java
}

inline fun <reified T: Activity> Context.startActivity(vararg params: Pair<String, String>){
    val intent = Intent(this, T::class.java)
    params.forEach { intent.putExtra(it.first, it.second) }
    startActivity(intent)
}

fun usageFun1(){
    Context().startActivity<AnyActivity>("data1" to "abc", "bundle2_str" to "aaa")
}

