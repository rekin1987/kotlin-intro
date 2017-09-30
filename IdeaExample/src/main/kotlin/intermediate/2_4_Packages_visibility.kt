package bbb


class MyPrivClass // fine here, we are in different package

fun aFun(){
//    aaa.MyPrivClass() // private
    MyPrivClass() // access to the class few lines above
}

