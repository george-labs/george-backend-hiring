fun main(args: Array<String>) {
    val fileReader = FileReaderImpl()
    val stopWordsReader = StopWordsReader()

    val input = if (args.isNotEmpty()) {
        fileReader.readFile(args[0])
    } else {
        println("Enter your text:")
        readlnOrNull() ?: ""
    }

    val wordCounter = WordCounter(
        stopWordsReader.getStopWordsAsSet(
            "src/main/resources/stopwords.txt"
        )
    );
    wordCounter.setInputText(input)

    println(
        "Number of words: ${wordCounter.countAllWords()}, " +
                "unique: ${wordCounter.countUniqueWords()}"
    )
}