package pl.emget.androidkotlinexample.web

class WebManager {

    companion object {
        val PEOPLE_LIST_URL = "http://emget.pl"
    }

    fun fetchUsersFromWeb(): List<String> {
        return listOf("aaa", "bbb", "cc")
    }

}