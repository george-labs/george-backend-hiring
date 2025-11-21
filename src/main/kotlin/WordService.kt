import java.io.File

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

    fun countAverageLength(input: String): Float {

        // Check empty values
        val trimmed = input.trim()
        if (trimmed.isEmpty()) {
            return 0F
        }

        val chunks = getChunks(trimmed)
        if (chunks.isEmpty()) {
            return 0F
        }
        return chunks.sumOf { s: String -> s.length }.toFloat() / chunks.size
    }

    private fun getStopWords() =
        WordService::class.java.getResourceAsStream("/stopwords.txt")
            ?.bufferedReader()
            ?.readLines()
            ?.associate { s: String -> s to s }
            .orEmpty()

    fun getChunks(trimmed: String): List<String> {
        val stopWords = getStopWords()

        // Split
        return trimmed.split(Regex("[^a-zA-Z\\-]+"))
            // Skip empty chunks
            .filter { s: String -> s.isNotEmpty() }
            // Skip stopwords
            .filterNot { s: String -> stopWords.containsKey(s) || s == "-" }
    }

    fun getIndex(input: String, dictionaryFileName: String?): Collection<String> {
        val dictionary: List<String>
        if (dictionaryFileName != null) {
            val file = File(dictionaryFileName)
            if (!file.exists()) {
                throw IllegalArgumentException("Dictionary $dictionaryFileName not found!")
            }
            dictionary = file.readLines()
        } else {
            dictionary = listOf()
        }
        return getChunks(input)
            .toSortedSet { t1, t2 -> t1.lowercase().compareTo(t2.lowercase()) }
            .map { if (dictionary.contains(it)) { it } else { "$it*" } }
    }
}