package advanced

import java.lang.IllegalArgumentException
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

// by lazy
// lateinit
// own delegate

class MyDatabase() {
    constructor(str: String) : this() {
        // init DB from string
    }
}

class SomeApp(val data: String) {
    //    val database = MyDatabase("init")
    val database: MyDatabase by lazy { MyDatabase("init") }
    lateinit var myString: String
        private set

    fun doSomething() {
        val strLen = myString.length // exception not initialized but used
    }

    // will be greater or equal zero
    val dateInMillis: Long by Delegates.vetoable(0L) { _, _, incomingVal ->
        println("inside lambda")
        incomingVal >= 0
    }

    var positiveInt: Int by PositiveIntDelegate()

    fun testPositiveInt() {

        // println("positiveInt = $positiveInt") // exception

        positiveInt = 14
        println("positiveInt = $positiveInt")

        positiveInt = -12
        println("positiveInt = $positiveInt")
    }

}

class PositiveIntDelegate {

    private var backingIntField: Int? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return backingIntField?.let { backingIntField!! } ?: throw IllegalArgumentException("My backing field is not initialized")
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value > 0) {
            backingIntField = value
        }
    }
}

val p = Pair("a", 1)
val p2 = "b" to 2

class Config(map: Map<String, Any>) {
    val width: Int by map
    val height: Int by map
    val name: String by map
}

val conf = Config(
        mapOf(
                "width" to 100, // same as Pair("width", 100)
                "height" to 50, // same as Pair("height", 50)
                "name" to "aName" // same as Pair("name", "aName")
        )
)