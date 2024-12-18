import inputReader.ConsoleInputReader
import inputReader.FileInputReader

fun main(args: Array<String>) {
    require(args.size < 2) { "More arguments are provided than what the program can handle, args:$args" }

    val stopWordsResourceName = "stopwords.txt"
    val stopWordLoader = StopWordLoader(stopWordsResourceName)

    val inputReader = InputReaderFactory({ readln() }, { print(it) }).getInputReader(args.get(0))
    val applicationController = WordCounter(
        stopWordLoader = stopWordLoader,
        inputReader = inputReader,
    )
    println("Number of words: ${applicationController.countWordsInText()}")
}