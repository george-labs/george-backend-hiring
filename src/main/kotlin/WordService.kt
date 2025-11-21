class WordService {
    fun countUnique(input: String): Int {

        // Check empty values
        val trimmed = input.trim()
        if (trimmed.isEmpty()) {
            return 0
        }

        return getChunks(trimmed).toSet().size
    }

    fun countWords(input: String): Int {

        // Check empty values
        val trimmed = input.trim()
        if (trimmed.isEmpty()) {
            return 0
        }

        return getChunks(trimmed).size
    }

    private fun getStopWords() =
        WordService::class.java.getResourceAsStream("/stopwords.txt")
            ?.bufferedReader()
            ?.readLines()
            ?.associate { s: String -> s to s }
            .orEmpty()


    private fun getChunks(trimmed: String): List<String> {
        val stopWords = getStopWords()

        // Split
        return trimmed.split(Regex("[^a-zA-Z]+"))
            // Skip empty chunks
            .filter { s: String -> s.isNotEmpty() }
            // Skip stopwords
            .filterNot { s: String -> stopWords.containsKey(s) }
    }
}