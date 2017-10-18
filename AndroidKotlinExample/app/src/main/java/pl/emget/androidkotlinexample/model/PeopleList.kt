package pl.emget.androidkotlinexample.model

class PeopleList {
    private var list : MutableList<JavaPerson>

    init {
        list = mutableListOf()
    }

    fun addPerson(person: JavaPerson){
        list.add(person)
    }
}

fun mockPeopleList() : PeopleList{
    val list = PeopleList()
    list.addPerson(Tester("Android", 5).apply { name = "Marek" })
    list.addPerson(Developer("Kotlin").apply { name = "Pawel" })
    list.addPerson(Developer("Java")) // forgot about name!
    return list
}