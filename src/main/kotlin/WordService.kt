class WordService {
    fun countWords(input: String): Int {
        val trimmed = input.trim()
        if (trimmed.isEmpty()) {
            return 0
        }
        val chunks = trimmed.split(Regex("[^a-zA-Z]+"))
            .filter {s: String -> s.isNotEmpty() }
        return chunks.size
    }
}