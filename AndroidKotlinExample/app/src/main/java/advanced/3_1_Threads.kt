package advanced

import kotlinx.coroutines.experimental.*

// gradle.properties - because experimental
//kotlin.coroutines=enable

fun coroutinesExample(){

    launch(CommonPool) {
        fetchImagesFromWebServer()
    }

    runBlocking {
        delay(1000)
    }

    val computedStr: Deferred<String> = async(CommonPool) {
       computeString() // returns String
    }

    runBlocking {
        // await is a suspend function - so it is inside runBlocking block
        val str: String = computedStr.await()
    }
}

//Suspend functions are only allowed to be called from a coroutine or another suspend function
suspend fun fetchImagesFromWebServer(){}

fun computeString() = "str"
