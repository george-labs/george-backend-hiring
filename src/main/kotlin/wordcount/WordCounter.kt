package wordcount

class WordCounter(
    private val stopwords: Stopwords,
    private val config: WordCounterConfig = WordCounterConfig()
) {

    fun countWords(input: String?): WordCountResult {
        if (input == null) return WordCountResult()

        val filteredWords = input
            .trim()
            .split(Regex(config.splitPattern))
            .map { it.lowercase().trim() }
            .filter { it.isNotBlank() && !stopwords.isStopword(it) }

        val averageLength = filteredWords.map { it.length }.average()

        return WordCountResult(
            numWords = filteredWords.size,
            unique = filteredWords.distinct().size,
            averageLength = averageLength
        )
    }
}