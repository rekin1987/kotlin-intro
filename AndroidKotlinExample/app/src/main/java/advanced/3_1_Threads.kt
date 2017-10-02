package advanced

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

