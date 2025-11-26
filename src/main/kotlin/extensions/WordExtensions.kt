package extensions

val wordRegex = "[A-Za-z-]+".toRegex()

fun String.isWord(): Boolean = matches(wordRegex)

fun String.getDividedWords(): List<String> = wordRegex.findAll(this).flatMap { it.groupValues }.toList()

fun List<String>.getFilteredWords(stopWords: List<String>?) = filter { word ->
    stopWords.filterStopWords(word) && word.isWord()
}

fun List<String>.countWords(stopWords: List<String>? = emptyList()): Int = getFilteredWords(stopWords).size
fun List<String>.countUnique(stopWords: List<String>? = emptyList()): Int = getFilteredWords(stopWords).toSet().count()
fun List<String>.countAverageWordLength(stopWords: List<String>? = emptyList()): String {
    val words = getFilteredWords(stopWords)
    return String.format("%.2f", words.toString().length.toDouble().div(words.size.toDouble()))
}

fun List<String>.sortWords(stopWords: List<String>? = emptyList()) =
    getFilteredWords(stopWords).sortedWith(
        compareBy(String.CASE_INSENSITIVE_ORDER) { it }
    )


fun List<String>?.filterStopWords(word: String): Boolean = this?.none { stopWord -> word == stopWord } == true