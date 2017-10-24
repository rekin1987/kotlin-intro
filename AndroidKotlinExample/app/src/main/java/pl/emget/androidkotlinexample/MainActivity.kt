package pl.emget.androidkotlinexample

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.alert
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
import pl.emget.androidkotlinexample.web.WebManager

class MainActivity : AppCompatActivity() {

    private lateinit var events: MutableList<Event> // make sure it is initialized before used!

    override fun onCreate(savedInstanceState: Bundle?) { // Bundle or null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // access to apiLabel TextView using ID (kotlin-android-extensions)
        apiLabel.apply {
            // functions defined globally - readApiName() and readApiLevel()
            text = "Running on Android ${readApiName()} (API ${readApiLevel()})"
        }
        titleLabel.text = "Events app"

        buttonDb.apply {
            setOnClickListener { readDb() }
            setOnLongClickListener { clearDb(); /*return*/ true  }
        }
        buttonWww.setOnClickListener { readWeb() }

        aboveLollipop {
            toast("Running Android above Lollipop") // shorthand for showing Toast
        }

        with(recyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity) // this refers to RecyclerView, to access MainActivity we use label '@"
            // divider between row in RecyclerView
            // (layoutManager as LinearLayoutManager) - because smart cast is not possible on VAR!
            addItemDecoration(DividerItemDecoration(context, (layoutManager as LinearLayoutManager).orientation))
        }
    }

    private fun readDb() {
        doAsync { // runs in background
            val ctx: Context = this@MainActivity // access to outer class instance if needed
            val localEvents = DatabaseSingleton.instance.readEntries()
            uiThread {
                // runs on UI thread
                refreshList(localEvents)
            }
        }
    }

    private fun clearDb() {
        doAsync { // runs in background
            // if this throws Exception app don't crash, because we are running in ExecutorService
            // same if we run in a coroutine
            // but app crashes in other cases!
            DatabaseSingleton.instance.clear()
            uiThread {
                // runs on UI thread
                refreshList(ArrayList<Event>())
            }
        }
    }

    private fun readWeb() {
        async(UI) {
            val items: Deferred<MutableList<Event>> = bg { WebManager().fetchEventsFromWeb() }
            val localEvents = items.await() // does not block UI thread
            refreshList(localEvents)
        }
    }

    private fun refreshList(collection: MutableList<Event>) {
        if (recyclerView.adapter == null) {
            events = collection
            recyclerView.adapter = EventsAdapter(events) {
                // on click
                clickedItem(it) // 'it' inside lambda
            }
        } else {
            events.clear()
            events.addAll(collection)
            recyclerView.adapter.notifyDataSetChanged()
        }
    }

    private fun clickedItem(event: Event) {
        alert { // creating alert dialog is so simple
            title = "Store ${event.title} do DB?"
            positiveButton("Add") { DatabaseSingleton.instance.addEntry(event) }
            negativeButton("Cancel") { it.dismiss() } // 'it' refers to DialogInterface
        }.show()
    }

}





