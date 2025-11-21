class WordService {
    fun countWords(input: String): Int {

        // Check empty values
        val trimmed = input.trim()
        if (trimmed.isEmpty()) {
            return 0
        }

        // Split
        val chunks = trimmed.split(Regex("[^a-zA-Z]+"))
            // Skip empty chunks
            .filter {s: String -> s.isNotEmpty() }

        return chunks.size
    }
}