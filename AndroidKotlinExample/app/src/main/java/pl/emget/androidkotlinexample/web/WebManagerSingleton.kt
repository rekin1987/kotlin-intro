package pl.emget.androidkotlinexample.web

import com.google.gson.Gson
import pl.emget.androidkotlinexample.model.CinemaEvent
import pl.emget.androidkotlinexample.model.Event
import pl.emget.androidkotlinexample.model.TheaterEvent
import java.net.URL

internal class WebManager {

    private companion object {
        val CINEMA_EVENTS_LIST_URL = "http://emget.pl/temp/cinema_events_list.json"
        val THEATER_EVENTS_LIST_URL = "http://emget.pl/temp/theater_events_list.json"
    }

    fun fetchEventsFromWeb(): MutableList<Event> {
        val cinemaEventsJsonStr = URL(CINEMA_EVENTS_LIST_URL).readText()
        val cinemaEventsWrapper = Gson().fromJson(cinemaEventsJsonStr, CinemaEventsWrapper::class.java)
        val theaterEventsJsonStr = URL(THEATER_EVENTS_LIST_URL).readText()
        val theaterEventsWrapper = Gson().fromJson(theaterEventsJsonStr, TheaterEventsWrapper::class.java)
        val allEvents: MutableList<Event> = ArrayList()
        allEvents.addAll(cinemaEventsWrapper.events)
        allEvents.addAll(theaterEventsWrapper.events)
        return allEvents
    }

}

private class CinemaEventsWrapper {
    lateinit var events: MutableList<CinemaEvent>
}
private class TheaterEventsWrapper {
    lateinit var events: MutableList<TheaterEvent>
}