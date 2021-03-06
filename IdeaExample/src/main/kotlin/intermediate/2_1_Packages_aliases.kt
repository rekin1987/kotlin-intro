package intermediate

// we are in different package, so need to import or use fully qualified name
import com.example.globalFun
// import with alias
import com.example.globalFun2 as gf2

fun myFun() {
    globalFun()
    gf2()
    com.example.globalFun() // when using fully qualified name we don't need to import
    // globalFun2() // function is not visible by name - must use alias!
}

