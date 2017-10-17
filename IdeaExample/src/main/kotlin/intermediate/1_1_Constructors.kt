package intermediate


private class MyWindow {

    var name = "default window"

    constructor() {
        // this is secondary constructor
    }

    constructor(str: String) {
        // this is secondary constructor
    }

     inner class Handle {
        val handleName = "handle for " + name /* OR MyWindow@name */
        val handleName2 = "handle for " + MyWindow@name
    }
}

private class MyDoor() { // class definition and primary constructor (no params)

    constructor(str: String) : this() {
        // this is secondary constructor, which must call the primary one!
    }

}

private class MagicDoor(val level: Int) { // primary constructor with property 'level'

    constructor() : this(1) {
        // this is secondary constructor, which must call the primary one!
    }
}

fun creatingWindowAndDoor() {
    var window = MyWindow()
    window = MyWindow("Windows XP")

    var door = MyDoor()
    door = MyDoor("woodden door")
}

class Aaaa1(amountParam: Int) {
    var amount = amountParam
}

class Aaaa2(var amount: Int) {
}

class A private constructor(private val ii: Int) {

    private constructor(a: String) : this(a.toInt()) {
    }
}

class Abc(val ii: Int) {

    // calls to primary constructor
    private constructor(a: String) : this(a.toInt()) {
    }

    // calls to secondary constructor (and in consequence to primary as well)
    // compiler understands the constructors call chain!
    constructor(a: Int, b: String) : this("abc") {
    }
}

class ClassE {
    companion object /* : InterfaceA */ {
        val name = "aaa"
    }

    object B /* : InterfaceA */ {
        val name = "bbb"
    }
}

fun testClassE() {
    ClassE.name // aaa
    ClassE.B.name // bbb
}

abstract class AbsClass{
    abstract fun absFun();

    fun normalFun(){

    }
}