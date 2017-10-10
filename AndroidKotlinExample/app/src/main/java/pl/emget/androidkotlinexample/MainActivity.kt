package pl.emget.androidkotlinexample

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiLabel.apply {
            text = "Running on Android ${readApiName()} (API ${readApiLevel()})"
        }
        titleLabel.text = "Events app"

        atLeastLollipop {
            toast("Running Lollipop")
            val drawable: Drawable
            // unfortunately we still need this 'if' in order to avoid compilation error
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                drawable = getDrawable(android.R.drawable.btn_plus)
            } else {
                drawable = applicationContext.resources.getDrawable(android.R.drawable.btn_plus)
            }
            val button = FloatingActionButton(this)

            button.apply {
                setImageDrawable(drawable)
                size = FloatingActionButton.SIZE_NORMAL
            }

            insertPoint.addView(button)

            buttonAdd.visibility = View.GONE
        }


//        readDb()
        readDb2()
    }

    fun readDb() {
        doAsync {
            // do in background
            val entries = DatabaseSingleton.readEntries()
            uiThread {
                // do on UI thread
                itemsListView.text = entries
            }
        }
    }

    fun readDb2() {
        // need experimental feature added in gradle.build
        async(UI) {
            val v1: Deferred<String> = bg { DatabaseSingleton.readEntries() }
            itemsListView.text = v1.await()
        }
    }

}





