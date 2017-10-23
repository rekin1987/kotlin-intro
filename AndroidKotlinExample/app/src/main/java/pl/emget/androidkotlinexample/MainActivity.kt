package pl.emget.androidkotlinexample

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import pl.emget.androidkotlinexample.additions.aboveLollipop
import pl.emget.androidkotlinexample.additions.readApiLevel
import pl.emget.androidkotlinexample.additions.readApiName
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
//        doAsync {  // runs in background
//            people = DatabaseSingleton.readEntries()
//            uiThread { // runs on UI thread
//                recyclerView.adapter = PeopleAdapter(people) {
//                    toast(it.name)
//                }
//            }
//        }
    }

    fun readDb2() {
//        async(UI) { // constant 'UI' from ANKO library refers to Android main UI thread
//            val items: Deferred<MutableList<Event>> = bg { DatabaseSingleton.readEntries() }
//            people = items.await()
//            recyclerView.adapter = PeopleAdapter(people) {
//                toast(it.name)
//            }
//        }
    }


}





