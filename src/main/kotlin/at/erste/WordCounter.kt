package at.erste

class WordCounter {
    private val skippedWords: Set<String>

    constructor(skippedWords: Collection<String>) {
        this.skippedWords = skippedWords.map { it.trim().lowercase() }.toSet()
    }

    fun countWords(input: String): WordCount {
        val wordCandidates = input
            .split(" ", "\r\n", "\n")
            .map { it.replace("([.,?!]*)$".toRegex(), "") }
            .filter { it.matches("([a-zA-Z]+)".toRegex()) }
            .filter { !skippedWords.contains(it.lowercase()) }
        val unique = wordCandidates.toSet()
        return WordCount(wordCandidates.size, unique.size)
    }
}
