import stopWorldLoader.DefaultStopWordLoader

fun main(args: Array<String>) {
    require(args.size < 2) { "More arguments are provided than what the program can handle, args:$args" }

    val stopWordsResourceName = "stopwords.txt"
    val defaultStopWordLoader = DefaultStopWordLoader(stopWordsResourceName)

    val printer = { value: String -> print(value) }
    val reader = { readln() }
    val inputTextFileName = if (args.size == 1) args.get(0) else null
    val inputReader = InputReaderFactory(reader, printer).getInputReader(inputTextFileName)
    val applicationController = WordCounter(
        stopWordLoader = defaultStopWordLoader,
        inputReader = inputReader,
    )
    println("Number of words: ${applicationController.countWordsInText()}")
}