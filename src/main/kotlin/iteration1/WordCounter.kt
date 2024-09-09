package iteration1

/**
 * The WordCounter class is used to analyze sentences and perform various word counting operations.
 * It can calculate the number of stop words, the average word length, the number of unique words,
 * and the total number of words in a given sentence.
 */
class WordCounter(val stopWords: Set<String> = mutableSetOf<String>(), val dictWords: Set<String> = mutableSetOf<String>()) {

    private val regex = "\\b[a-zA-Z-]+\\b".toRegex()


    /**
     * Returns the number of stop words in the stopWords list.
     *
     * @return the number of stop words as an integer value.
     */
    fun stopWordsCount():Int = stopWords.size

    fun dictWordsCount():Int = dictWords.size


    fun getWords(sentence: String?):List<String>  {
        return sentence?.let {
            regex.findAll(sentence)
                .map { it.value.trim() }
                .map { it.lowercase() }
                .filter { !stopWords.contains(it) }
                .toList()
        } ?: emptyList()
    }

    fun getMarkedWords(sentence: String?):List<String> {
        return sentence?.let {
            regex.findAll(sentence)
                .map { it.value.trim() }
                .map { it.lowercase() }
                .filter { !stopWords.contains(it) }
                .map { if (dictWords.contains(it)) it else ("$it*") }
                .toList()
        } ?: emptyList()
    }

    /**
     * Calculates the average word length of a given sentence.
     *
     * @param sentence the sentence to calculate the average word length from
     * @return the average word length as a Double value. Returns 0.0 if the sentence is null or empty.
     */
    fun countAverageWordLength(sentence: String?):Double  {
        val words = getWords(sentence)

        words.let {
            val totalLength = words.sumOf { it.length }

            // Calculate the number of words
            val numberOfWords = words.size

            // Calculate the average length
            return if (numberOfWords > 0) {
                totalLength.toDouble() / numberOfWords
            } else {
                0.0
            }
        }
    }

    /**
     * Counts the number of unique words in a given sentence.
     *
     * @param sentence the sentence to count unique words from
     * @return the number of unique words in the sentence. Returns 0 if the sentence is null or empty.
     */
    fun countUniqueWords(sentence: String?): Int {
        return getWords(sentence).toSet().size
    }

    /**
     * Counts the number of words in a given sentence.
     *
     * @param sentence the sentence to count words from
     * @return the number of words in the sentence. Returns 0 if the sentence is null.
     */
    fun countWords(sentence: String?): Int {
        return getWords(sentence).size
    }
}