class WordService {
    fun countWords(input: String): Int {

        // Check empty values
        val trimmed = input.trim()
        if (trimmed.isEmpty()) {
            return 0
        }

        val stopWords = getStopWords()

        // Split
        val chunks = trimmed.split(Regex("[^a-zA-Z]+"))
            // Skip empty chunks
            .filter {s: String -> s.isNotEmpty() }
            // Skip stopwords
            .filterNot {s: String -> stopWords.containsKey(s) }

        return chunks.size
    }

    private fun getStopWords() =
        WordService::class.java.getResourceAsStream("/stopwords.txt")
            ?.bufferedReader()
            ?.readLines()
            ?.associate { s: String -> s to s }
            .orEmpty()
}