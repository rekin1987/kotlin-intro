package advanced


import kotlinx.coroutines.experimental.*

val now = System.currentTimeMillis()

fun corTest() {
    val v1: Deferred<String> = async { bgTask() }

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

fun corTest2() {
    myPrint("corTest2")
    runBlocking {
        myPrint("runBlocking")
        delay(1000)
        myPrint("runBlocking END")
    }
    myPrint("2")

    Thread.sleep(2000)
    myPrint("finished")
}


fun bgTask(): String {
    myPrint(">>bgTask()")
    Thread.sleep(2000)
    myPrint("<<bgTask()")
    return "aa"
}

fun myPrint(msg: String) {
    println("${System.currentTimeMillis() - now} - $msg")
}