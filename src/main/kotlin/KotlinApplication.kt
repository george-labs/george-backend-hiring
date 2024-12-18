import inputReader.ConsoleInputReader
import inputReader.FileInputReader

fun main(args: Array<String>) {
    require(args.size < 2) { "More arguments are provided than what the program can handle, args:$args" }

    val stopWordsResourceName = "stopwords.txt"
    val stopWordLoader = StopWordLoader(stopWordsResourceName)
//    val stopWords = stopWordLoader.loadFromResources(stopWordsResourceName)
//    val inputReader = if (args.size == 1)
//        ConsoleInputReader()
//    else
//        FileInputReader()

    val applicationController = ApplicationController(args.get(0), stopWordLoader, inputReaders = listOf())
//        print("Enter text: ")

//    val userInput = readln()
    println("Number of words: ${applicationController.countWords()}")
}