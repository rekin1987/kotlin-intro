package examples

import java.net.URL

 class MyResult{
    var id: Int? = null
    var title: String? = null
}

private object gson{
    fun <T> fromJson(str: String, clazz: Class<T>) : T {
        return 1 as T
    }
}

 fun execute(): MyResult {
    val moviesJsonStr = URL("http://mydomain.com/movies.json").readText()
    return gson.fromJson(moviesJsonStr, MyResult::class.java)
}