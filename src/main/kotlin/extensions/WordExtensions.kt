package extensions

fun String.isWord(): Boolean = matches("[A-Za-z]+".toRegex())
fun String.getDividedWords(): List<String> = split(" ")
fun List<String>.countWords(stopWords: List<String>? = emptyList()): Int = filter { word ->
    stopWords.filterStopWords(word) && word.isWord()
}.size

fun List<String>?.filterStopWords(word: String): Boolean = this?.none { stopWord -> word == stopWord } == true