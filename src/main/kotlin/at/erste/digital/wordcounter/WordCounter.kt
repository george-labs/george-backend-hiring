package at.erste.digital.wordcounter

class WordCounter(private val stopWords: List<String> = emptyList()) {
    fun countWords(text: String): Int {
        if(text.isBlank()) return 0
        return text.trim()
            .split(" ","\t","\n")
            .filter { it.matches("[a-zA-Z]+".toRegex()) }
            .filterNot { it in stopWords }
            .size
    }
}