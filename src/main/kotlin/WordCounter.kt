
class WordCounter(
    private val stopWords: Set<String> = emptySet()
) {

    private val wordRegex = "([a-zA-Z]+)".toRegex()

    fun countWordsInText(text: String): Int {
        return wordRegex
            .findAll(text)
            .filter { !stopWords.contains(it.value) }
            .count()
    }

}