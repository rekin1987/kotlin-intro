package basics

fun fun1() {/*body*/}

fun fun2(name: String) {/*body*/}

fun fun22(name: String = "defaultName") {/*body*/}

fun fun3(value: Int): String {
    return "something"
}

fun fun4(value: Int) = "something"  // inferred return type



class OrdinaryClass {
    fun funWithString(name: String) {/*body*/}
}

fun OrdinaryClass.additionalFunction(value: Int){
    // some additional functionality for OrdinaryClass
}


fun createTree(radius: Int = 2, height: Int = 7, type: String = "Pine") : String {
    return type
}

fun testDefaultParams() {
    // note the radius and height are taken as default!
    val myOakTreeType = createTree(type = "Oak")
}