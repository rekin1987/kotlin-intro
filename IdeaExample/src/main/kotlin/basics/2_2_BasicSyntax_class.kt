package basics

class MyClass {
    fun myFun(param1: Int, param2: String = "default_text"): Unit { /*body*/ }
}

object MySingleton {
    var callCount = 0

    fun callMe(){
        ++callCount
    }
}

fun usage(){
    val cl = MyClass()
    cl.myFun(5) // uses default value for String param2

    MySingleton.callMe() // this is NOT a static method call
}

enum class Direction {
    UP, DOWN, LEFT, RIGHT
}

interface Moveable {
    fun move(direction: Direction, byPixels: Int)

    fun jump(high: Int) {
        move(Direction.UP, high)
    }
}
