package wordcount

/**
 * Main service that is responsible for counting words in a given input string
 */
class WordCounter(
    private val stopwords: Stopwords,
    private val config: WordCounterConfig = WordCounterConfig()
) {

    fun countWords(input: String?): WordCountResult {
        if (input == null) return WordCountResult()

        val filteredWords = input
            .trim()
            .split(Regex(config.splitPattern))
            .map { Pair(it.lowercase().trim(), it) }
            .filter { it.first.isNotBlank() && !stopwords.isStopword(it.first) }

        val averageLength = filteredWords.map { it.first.length }.average()

        return WordCountResult(
            numWords = filteredWords.size,
            unique = filteredWords.map { it.first }.distinct().size,
            averageLength = averageLength,
            index = filteredWords.distinctBy { it.first }.map { it.second }
        )
    }
}