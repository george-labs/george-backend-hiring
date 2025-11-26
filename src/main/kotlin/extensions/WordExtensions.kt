package extensions

fun String.isWord(): Boolean = matches("[A-Za-z]+".toRegex())
fun String.getDividedWords(): List<String> = split(" ")
fun List<String>.countWords(): Int = filter { it.isWord() }.size