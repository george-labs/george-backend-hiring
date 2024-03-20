fun main() {
    val fileReader = StopWordsFileReader("stopwords.txt")
    val wordCounter = WordCounter(fileReader)
    println("Enter text:")
    val text = readLine() ?: ""
    val wordCount = wordCounter.countWords(text)
    println("Number of words: $wordCount")
}
