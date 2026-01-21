package wordcount

class Stopwords(words: List<String>) {

    val stopwords: Set<String> = words.map { it.lowercase().trim() }.toSet()

    fun isStopword(word: String?): Boolean {
        if (word == null) return false
        return stopwords.contains(word.lowercase().trim())
    }

    companion object {

        fun fromResource(fileName: String): Stopwords {
            val words = Thread.currentThread()
                .contextClassLoader
                .getResourceAsStream(fileName)
                ?.bufferedReader()
                ?.use { it.readLines().map { it.trim() } }
                ?: listOf()

            return Stopwords(words)
        }
    }

}