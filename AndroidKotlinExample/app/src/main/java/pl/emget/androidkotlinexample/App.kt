package pl.emget.androidkotlinexample

import android.app.Application

internal class App : Application() {

    internal companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}