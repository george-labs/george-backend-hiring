import abstract.StopWordsLoader

class WordCounter(private val fileLoader: StopWordsLoader) {

    // NOTE: I would put this outside of the class as it doesn't depend on the context and we can test it more easily without the mock
    fun countUniqueWords(words: List<String>): Int {
        return words.map { it.uppercase() }.toSet().count()
    }

    // words are stretches of letters (a-z,A-Z)
    // not containing stopwords
    fun getWordsWithoutStopwords(line: String): List<String> {
        if (line.isEmpty()) {
            return emptyList()
        }
        return line.split("[\\s-]+".toRegex())
            .map { removeLastDotOrComma(it) }
            .filter { isWord(it) }
            .filter { !isStopword(it) }
    }

    // NOTE: I would put this outside of the class as it doesn't depend on the context and we can test it more easily without the mock
    fun removeLastDotOrComma(it: String) = if (it.isNotEmpty() && (it.last() == '.' || it.last() == ',')) {
        it.dropLast(1)
    } else it

    // NOTE: I would put this outside of the class as it doesn't depend on the context and we can test it more easily without the mock
    fun isWord(word: String): Boolean {
        return word.matches("[a-zA-Z]+".toRegex())
    }

    // Stopwords are defined in the file stopwords.txt
    fun isStopword(word: String): Boolean {
        val stopWords = fileLoader.getStopWords()

        return stopWords.contains(word)
    }
}