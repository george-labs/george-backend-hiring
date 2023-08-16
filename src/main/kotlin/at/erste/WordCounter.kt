package at.erste

class WordCounter {
    private val skippedWords: Set<String>
    constructor(skippedWords: Collection<String>) {
        this.skippedWords = skippedWords.map { it.trim().lowercase() }.toSet()
    }
    fun countWords(input: String): Int {
        val wordCandidates = input
            .split(" ", "\r\n", "\n")
            .filter { it.matches("([a-zA-Z]+)([.,?!]*)".toRegex()) }
            .filter { !skippedWords.contains(it.lowercase()) }
        return wordCandidates.size
    }
}
