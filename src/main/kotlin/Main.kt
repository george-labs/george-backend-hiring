fun main(args: Array<String>) {
    val fileReader = FileReaderImpl()

    val input = if (args.isNotEmpty()) {
        fileReader.readFile(args[0])
    } else {
        println("Enter your text:")
        readlnOrNull() ?: ""
    }

    val wordCounter = WordCounter(fileReader);
    val wordsList = wordCounter.getWords(input)

    println(
        "Number of words: ${wordCounter.countAllWords(wordsList)}, " +
                "unique: ${wordCounter.countUniqueWords(wordsList)}"
    )
}