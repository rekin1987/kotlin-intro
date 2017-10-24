package pl.emget.androidkotlinexample.model


class CinemaEvent(freeSpots: Int = 0) : Event() {
    var freeSpots: Int

    init {
        this.freeSpots = freeSpots
    }
}