fun main(args: Array<String>) {
    val stopWordsFileReader = StopWordsFileReader("stopwords.txt")
    val wordCounter = WordCounter(stopWordsFileReader)

    val text = if (args.isNotEmpty()) {
        try {
            val inputFileReader = InputFileReader(args[0])
            inputFileReader.readText()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getUserInput()
        }
    } else {
        getUserInput()
    }

    val wordCount = wordCounter.countWords(text)
    println("Number of words: $wordCount")
}

fun getUserInput(): String {
    println("Enter text:")
    return readLine() ?: ""
}
