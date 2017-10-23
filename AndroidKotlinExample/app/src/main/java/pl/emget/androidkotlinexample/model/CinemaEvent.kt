package pl.emget.androidkotlinexample.model


class CinemaEvent(freeSpots: Int) : Event() {
    val freeSpots: Int

    init {
        this.freeSpots = freeSpots
    }
}