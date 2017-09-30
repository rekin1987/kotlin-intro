package intermediate

fun checkSmartCasts() {

    val mayBeNull: String? = null
    val mayBeNull2: String? = "not null"

//    val len = mayBeNull.length // can't access nullable type like this
//    val len2 = mayBeNull2.length // can't access nullable type like this - it does not matter that it is initialized!
    val len3 = mayBeNull?.length // good, with '?' syntax we can access nullable type
    val len4 = mayBeNull2?.length // good, with '?' syntax we can access nullable type

    val len5 = mayBeNull!!.length // '!!' says "I am sure it is not null, let me use it!"

    if (mayBeNull != null) {
        val len6 = mayBeNull.length // smart cast String? -> String
    }

    val anyString: Any = "any"

    when (anyString) {
        is String -> print(anyString.length) // smart cast Any -> String
        "any" -> print("string contains text 'any'")
    }

}