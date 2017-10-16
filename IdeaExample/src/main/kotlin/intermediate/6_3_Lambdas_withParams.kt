package intermediate

fun customPrint(text: String, printerFun: (String) -> Unit) {
    printerFun(text)
}

fun useCustomPrint() {
    customPrint("lambda with named param") { someText -> print("printing: " + someText) }
    customPrint("it: implicit name of a single parameter") { print("printing: " + it) }
    customPrint("using 'it' again - with new line") { println("printing: " + it) }
}

fun replaceChar(text: String, replacer: (String, Char, Char) -> String): String {
    return replacer(text, '.', ':')
}

fun useReplaceChar() {
    val str = "some.text..is in here."
    var replaced = replaceChar(str) { txt, chOld, chNew -> txt.replace(chOld, chNew) }
    println(replaced) // some:text::is in here:
    replaced = replaceChar(str) { txt, _, _ -> txt.toUpperCase() } // ignore some unused params names
    println(replaced) // SOME.TEXT..IS IN HERE.
}

