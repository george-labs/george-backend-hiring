package extensions

val wordRegex = "[A-Za-z-]+".toRegex()

fun String.isWord(): Boolean = matches(wordRegex)

fun String.getDividedWords(): List<String> = wordRegex.findAll(this).flatMap { it.groupValues }.toList()

fun List<String>.getFilteredWords(stopWords: List<String>?) = filter { word ->
    stopWords.filterStopWords(word) && word.isWord()
}

fun List<String>.countWords(): Int = size
fun List<String>.countUnique(): Int = toSet().count()
fun List<String>.countAverageWordLength(): String = String.format("%.2f", toString().length.toDouble().div(size.toDouble()))


fun List<String>.sortWords() =
    sortedWith(
        compareBy(String.CASE_INSENSITIVE_ORDER) { it }
    )


fun List<String>?.filterStopWords(word: String): Boolean = this?.none { stopWord -> word == stopWord } == true