package at.erste.digital.wordcounter

object WordCounter {
    fun countWords(text: String): Int {
        if(text.isBlank()) return 0
        return text.split(" ").size
    }
}