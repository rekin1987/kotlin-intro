package pl.emget.androidkotlinexample

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import pl.emget.androidkotlinexample.additions.aboveLollipop
import pl.emget.androidkotlinexample.additions.readApiLevel
import pl.emget.androidkotlinexample.additions.readApiName
import pl.emget.androidkotlinexample.components.EventsAdapter
import pl.emget.androidkotlinexample.database.DatabaseSingleton
import pl.emget.androidkotlinexample.model.Event

class MainActivity : AppCompatActivity() {

    private lateinit var events: MutableList<Event>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiLabel.apply {
            text = "Running on Android ${readApiName()} (API ${readApiLevel()})"
        }
        titleLabel.text = "Events app"

        buttonSave.setOnClickListener { saveToDb() }
        buttonAdd.setOnClickListener { showAddPersonDialog() }

        aboveLollipop {
            toast("Running Android above Lollipop")
            val floatingButton = FloatingActionButton(this)
            floatingButton.apply {
                size = FloatingActionButton.SIZE_NORMAL
                setOnClickListener { showAddPersonDialog() }
            }
            // add floating button
            insertPoint.addView(floatingButton)
            // hide casual "add" button
            buttonAdd.visibility = View.GONE
        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        readDb()
    }

    fun showAddPersonDialog() {
        toast("showAddPersonDialog()")
    }

    fun saveToDb() {
        toast("saveToDb()")
    }

    fun readDb() {
        doAsync {
            // runs in background
            val ctx: Context = this@MainActivity // access to outer class instance if needed
            events = DatabaseSingleton.instance.readEntries()
            uiThread {
                // runs on UI thread
                recyclerView.adapter = EventsAdapter(events) {
                    // on click
                    toast(it.title)
                }
            }
        }
    }

    fun readDb2() {
        async(UI) {
            // constant 'UI' from ANKO library refers to Android main UI thread
            val items: Deferred<MutableList<Event>> = bg { DatabaseSingleton.instance.readEntries() }
            events = items.await() // does not bloc UI thread
            recyclerView.adapter = EventsAdapter(events) {
                // on click
                toast(it.title)
            }
        }
    }


}





