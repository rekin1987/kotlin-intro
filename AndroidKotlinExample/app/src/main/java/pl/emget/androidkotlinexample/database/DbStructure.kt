package pl.emget.androidkotlinexample.database


object EventsTable {
    val ID = "_id" // int
    val TITLE = "title" // text
    val TIME = "time" // int
    val DATA = "data" // text
    val TYPE = "type" // text - type of event: 'C' for CinemaEvent, 'T' for TheaterEvent
}