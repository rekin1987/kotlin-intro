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

fun myFun1() {/*body*/}

fun myFun2() = "returning a string"

//fun myFun5() = myFun2() // this is NOT a function pointer assignment!
//this is
fun myFun5() {
    myFun2()
}

//// function 'pointers' example
fun function1(x: Int) {
    println("val=$x")
}

val function2 = ::function1 // KProperty< KFunction <Int, Unit> >

fun function3(aFunction: (Int) -> Unit) {
    aFunction.invoke(5)
}

fun abbbb(){
    function1(1)
    function2(5)
    function3(::function1)
    //function3(::function2) // does not compile
}