package intermediate

// class can be declared as:
//open
//sealed
//inner
//abstract
//data

private class MyWindow {

    var name = "default window"

    constructor() {
        // this is secondary constructor, which must call the primary one!
    }

    constructor(str: String) {
        // this is primary constructor!
    }

     inner class Handle {
        val handleName = "handle for " + name /* OR MyWindow@name */
        val handleName2 = "handle for " + MyWindow@name
    }


}

private class MyDoor() {

    constructor(str: String) : this() {
        // this is secondary constructor, which must call the primary one!
    }
}

fun creatingWindowAndDoor() {
    var window = MyWindow()
    window = MyWindow("Windows XP")

    var door = MyDoor()
    door = MyDoor("woodden door")

}


class A private constructor(private val ii: Int) {

    private constructor(a: Long) : this(a.toInt()) {
    }

    constructor(a: Int, b: String) : this(a) {
    }

}

class Aaaa1(amount: Int) {
    var amount = amount
}

class Aaaa2(var amount: Int) {
}

sealed class B()

private open class C : B(), In, InA

interface In {
}

interface InA {
}

interface InB : In, InA {
    fun execute()
    fun run(a: Int): String {
        return (a * 2).toString()
    }
}

enum class Consts {
    MAX, MIN, AVERAGE
}

class D : InB {
    override fun execute() {
        run(5)
    }
}

class E {
    companion object : InA {
        val name = "aaa"
    }

    object B : InA {
        val name = "bbb"
    }
}

fun testClasses() {
    E.B.name // bbb
    E.name // aaa
}