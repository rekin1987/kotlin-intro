package examples

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*
import pl.emget.androidkotlinexample.App


private class DbExample(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(ctx, DB_NAME) {

    companion object {
        val DB_NAME = "MyDatabase.db"
        val PEOPLE_TABLE_NAME = "PeopleTable"
        val instance by lazy { DbExample() }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(PEOPLE_TABLE_NAME, true,
                PeopleTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                PeopleTable.NAME to TEXT,
                PeopleTable.TYPE to TEXT,
                PeopleTable.DATA to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }
}

private object PeopleTable {
    val ID = "_id"
    val NAME = "name"
    val TYPE = "type"
    val DATA = "data"
}

fun selectDevs() =
    DbExample.instance.use {
        select(DbExample.PEOPLE_TABLE_NAME)
                .whereSimple("${PeopleTable.TYPE} = ?", "DEV")
                .parseList(object : RowParser<String> {
                    override fun parseRow(columns: Array<Any?>): String {
                        var data: String = "ITEM: "
                        columns.forEach { data += it?.toString() ?: "" }
                        return data
                    }
                })
    }

fun insertInto(){
    DbExample.instance.use {
        insert(DbExample.PEOPLE_TABLE_NAME, PeopleTable.NAME to "Pawel", PeopleTable.TYPE to "DEV", PeopleTable.DATA to "Kotlin")
        insert(DbExample.PEOPLE_TABLE_NAME, PeopleTable.NAME to "Pawel2", PeopleTable.TYPE to "TEST", PeopleTable.DATA to "Android")
        insert(DbExample.PEOPLE_TABLE_NAME, PeopleTable.NAME to "Pawel3", PeopleTable.TYPE to "DEV", PeopleTable.DATA to "Java")
    }
}
