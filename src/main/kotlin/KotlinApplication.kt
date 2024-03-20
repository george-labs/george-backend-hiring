fun main() {
    val wordCounter = WordCounter()
    println("Enter text:")
    val text = readLine() ?: ""
    val wordCount = wordCounter.countWords(text)
    println("Number of words: $wordCount")
}
