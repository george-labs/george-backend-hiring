package wordcount

class WordCounter(private val stopwords: Stopwords) {

    fun countWords(input: String?): Int {
        if (input == null) return 0

        return input
            .trim()
            .split(Regex("[^A-Za-z]+"))
            .filter { it.isNotBlank() && !stopwords.isStopword(it) }
            .size
    }
}