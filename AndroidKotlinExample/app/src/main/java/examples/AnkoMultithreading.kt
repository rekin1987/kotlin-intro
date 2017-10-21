package examples

import android.content.Context
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class AnkoMultithreading {

    fun fetchData1(context: Context) {
        doAsync {
            // runs in background
            val filesList = fetchFilesListJson()
            uiThread {
                // runs on UI thread
                context.toast("Downloaded list: $filesList")
            }
        }
    }

    fun fetchData2(context: Context) {
        async(UI) {
            // constant 'UI' from ANKO library refers to Android main UI thread
            // runs on UI thread
            val filesListFuture: Deferred<String> = bg {
                // runs in background
                // last line is return
                fetchFilesListJson()
            }
            val filesList = filesListFuture.await()
            context.toast("Downloaded list: $filesList")
        }
    }

    fun fetchData3(context: Context) {
        async(CommonPool) {
            // runs in background
            val filesListFuture: Deferred<String> = bg {
                // last line is return
                fetchFilesListJson()
            }
            val filesList = filesListFuture.await()

            launch(UI) { // constant 'UI' from ANKO library refers to Android main UI thread
                // runs on UI thread
                context.toast("Downloaded list: $filesList")
            }
        }
    }

    fun fetchFilesListJson() = "mockup"
}