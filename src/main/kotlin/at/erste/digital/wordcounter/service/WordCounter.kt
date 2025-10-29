package at.erste.digital.wordcounter.service

class WordCounter(private val stopWords: List<String> = emptyList()) {
    fun countUniqueWords(text: String): Int {
        return getWords(text).toHashSet().size
    }

    fun countWords(text: String): Int {
        if(text.isBlank()) return 0
        return getWords(text)
            .size
    }

    private fun getWords(text: String): List<String> = text.trim()
        .split(" ", "\t", "\n")
        .filter { it.matches("[a-zA-Z]+".toRegex()) }
        .filterNot { it in stopWords }
}