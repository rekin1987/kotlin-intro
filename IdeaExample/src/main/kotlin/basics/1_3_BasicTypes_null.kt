package basics


fun nullOrNotNull() {
    val mightBeNull: Float? = null
    val mightBeAnotherNull = null // type 'Nothing?'

    // val notNullLong: Long = null // can't assign null

    // val vv: Int = mightBeAnotherNull // require type Int, but have type Nothing?
}

fun additionalNullCheck(){
    var nullString: String? = "qwerty"
//    val strLen = nullString.length // does not compile - missing null check '?'
    val strLen2 = nullString?.length // length is 6
    nullString = null
    val strLen3 = nullString?.length // null and the type of strLen3 is Int?
}