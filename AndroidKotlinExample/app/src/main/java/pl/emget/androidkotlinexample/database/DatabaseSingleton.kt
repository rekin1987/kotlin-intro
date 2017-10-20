package pl.emget.androidkotlinexample.database

import pl.emget.androidkotlinexample.model.Developer
import pl.emget.androidkotlinexample.model.JavaPerson
import pl.emget.androidkotlinexample.model.Tester

object DatabaseSingleton {

    object Internal {
        val internalList = mutableListOf(
                Developer("Kotlin 1.1").apply { name = "jakis dev" },
                Tester("Android", 100).apply { name = "super tester" }
        )
    }

    fun readEntries(): MutableList<JavaPerson> {
        return Internal.internalList
    }

    fun addEntry(entry: JavaPerson) {
        Internal.internalList += entry
    }
}