package pl.emget.androidkotlinexample.model


internal class CinemaEvent(freeSpots: Int = 0) : Event() {
    var freeSpots: Int

    init { // primary constructor block
        this.freeSpots = freeSpots
    }
}