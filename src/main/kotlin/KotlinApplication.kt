fun main() { // put here arguments for input text "mytext.txt"
    val stopWordsFileReader = StopWordsFileReader("stopwords.txt")
    val wordCounter = WordCounter(stopWordsFileReader)

    val inputFileReader = InputFileReader("mytext.txt")
    var text = inputFileReader.readText()

    if (text == null) {
        println("Enter text:")
        val text = readLine() ?: ""
    }

    val wordCount = wordCounter.countWords(text)
    println("Number of words: $wordCount")
}
