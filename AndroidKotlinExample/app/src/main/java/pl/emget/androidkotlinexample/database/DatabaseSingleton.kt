package pl.emget.androidkotlinexample.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*
import pl.emget.androidkotlinexample.App
import pl.emget.androidkotlinexample.model.CinemaEvent
import pl.emget.androidkotlinexample.model.Event
import pl.emget.androidkotlinexample.model.TheaterEvent
import java.util.*


class DatabaseSingleton private constructor(context: Context = App.instance) : ManagedSQLiteOpenHelper(context, DB_NAME) {

    companion object {
        val DB_NAME = "Events.db"
        val EVENTS_TABLE_NAME = "Events"
        val EVENT_TYPE_CINEMA = "C"
        val EVENT_TYPE_THEATER = "T"
        val instance by lazy { DatabaseSingleton() }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(EVENTS_TABLE_NAME, true,
                EventsTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                EventsTable.TITLE to TEXT,
                EventsTable.TIME to INTEGER,
                EventsTable.TYPE to TEXT,
                EventsTable.DATA to TEXT,
                EventsTable.FREE_SPOTS to INTEGER,
                EventsTable.ELEGANT to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

    fun readEntries(): MutableList<Event> {
        return selectAll().toMutableList()
    }

    fun storeList(events: MutableList<Event>) {
        events.forEach { addEntry(it) }
    }

    fun clear() {
        instance.use {
            delete(EVENTS_TABLE_NAME) // NOT dropTable!
        }
    }

    fun addEntry(entry: Event) {
        instance.use {
            insert(EVENTS_TABLE_NAME,
                    EventsTable.TITLE to entry.title,
                    EventsTable.TIME to entry.time,
                    EventsTable.TYPE to if (entry is CinemaEvent) EVENT_TYPE_CINEMA else EVENT_TYPE_THEATER,
                    EventsTable.DATA to entry.data,
                    if (entry is CinemaEvent)
                        EventsTable.FREE_SPOTS to entry.freeSpots
                    else
                        EventsTable.ELEGANT to if ((entry as TheaterEvent).formalOutfitRequired) 1 else 0
            )
        }
    }

    private fun selectAll() =
            instance.use {
                select(EVENTS_TABLE_NAME)
                        //.whereSimple("${EventsTable.TYPE} = ?", EVENT_TYPE_CINEMA)
                        .parseList(object : RowParser<Event> {
                            override fun parseRow(columns: Array<Any?>): Event {
                                val cinemaType = (columns[3] as String).equals(EVENT_TYPE_CINEMA)
                                val event = if (cinemaType) {
                                    CinemaEvent().apply {
                                        freeSpots = (columns[5] as Long).toInt()
                                    }
                                } else {
                                    TheaterEvent().apply {
                                        formalOutfitRequired = (columns[6] as Long).toInt() == 1
                                    }
                                }
                                return event.apply {
                                    title = columns[1].toString()
                                    time = columns[2] as Long
                                    data = columns[4].toString()
                                }
                            }
                        })
            }
}