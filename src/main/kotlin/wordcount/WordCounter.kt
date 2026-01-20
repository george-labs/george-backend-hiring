package wordcount

class WordCounter(private val stopwords: Stopwords) {

    fun countWords(input: String?): WordCountResult {
        if (input == null) return WordCountResult()

        val filteredWords = input
            .trim()
            .split(Regex("[^A-Za-z]+"))
            .map { it.lowercase().trim() }
            .filter { it.isNotBlank() && !stopwords.isStopword(it) }

        return WordCountResult(
            numWords = filteredWords.size,
            unique = filteredWords.distinct().size,
        )
    }
}