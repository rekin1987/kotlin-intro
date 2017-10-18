package pl.emget.androidkotlinexample.model


class Developer(favouriteLanguage: String) : JavaPerson() {
    val favouriteLanguage: String

    init {
        this.favouriteLanguage = favouriteLanguage
    }
}