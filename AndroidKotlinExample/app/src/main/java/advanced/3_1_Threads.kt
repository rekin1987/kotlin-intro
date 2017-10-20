package advanced

import kotlinx.coroutines.experimental.*

//build.gradle:
//compile "org.jetbrains.anko:anko-coroutines:$anko_version"
// gradle.properties - because experimental
//kotlin.coroutines=enable


fun multithreadingAndroid() {
    // ANKO library for Android only:
//    doAsync {
//        val count = fetchImagesFromWebServer()
//        uiThread {
//            toast("$count images fetched")
//        }
//    }
}

fun coroutinesGeneral() {
    // need experimental feature added in gradle.build
//    async(UI) {
//        val v1: Deferred<Result> = bg {  fetchImagesFromWebServer() }
//        updateUI(v1.await())
//    }
}

//fun readDb2() {
//    async(UI) {
//        val v1: Deferred<String> = bg { DatabaseSingleton.readEntries() }
////            itemsListView.text = v1.await()
//    }
//}


var now = 0L

fun main(args: Array<String>) {
    myPrint("Running Kotlin")
    now = System.currentTimeMillis()

    val v1: Deferred<String> = async(CommonPool) {
        bgTask()
    }

    myPrint("2")
    Thread.sleep(3000)

    runBlocking {
        myPrint("run blocking")
        val s = v1.await()
        myPrint("deferred = $s")
    }
    myPrint("3")

    // Start a coroutine
    launch(CommonPool) {
        myPrint("start coroutine")
        delay(1000)
        myPrint("Hello")
    }
    myPrint("4")

    Thread.sleep(4000) // wait for 2 seconds
    myPrint("Stop")

}

fun bgTask(): String  {
    myPrint(">>bgTask()")
    Thread.sleep(2000)
    myPrint("<<bgTask()")
    return "aa"
}

fun myPrint(msg: String){
    println("${System.currentTimeMillis()-now} - $msg")
}

//EXECUTE:
//1508442541678 - Running Kotlin
//55 - 2
//56 - >>bgTask()
//2056 - <<bgTask()
//3069 - run blocking
//3070 - deferred = aa
//3070 - 3
//3072 - 4
//3072 - start coroutine
//4083 - Hello
//7072 - Stop