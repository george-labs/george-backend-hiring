package extensions

val wordRegex = "[A-Za-z]+".toRegex()

fun String.isWord(): Boolean = matches(wordRegex)
fun String.getDividedWords(): List<String> = wordRegex.findAll(this).flatMap { it.groupValues }.toList()
fun List<String>.countWords(stopWords: List<String>? = emptyList()): Int = filter { word ->
    stopWords.filterStopWords(word) && word.isWord()
}.size

fun List<String>.countUnique(stopWords: List<String>? = emptyList()): Int = filter { word ->
    stopWords.filterStopWords(word) && word.isWord()
}.toSet().count()

fun List<String>?.filterStopWords(word: String): Boolean = this?.none { stopWord -> word == stopWord } == true