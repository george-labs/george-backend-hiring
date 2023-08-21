import java.io.FileNotFoundException
import kotlin.system.exitProcess

fun readStopWordsFile(path: String): List<String> {
    val file: FileReader = ReadFile(path)

    try {
        return file.readLines().map { it.trim() }.filter { it.isNotEmpty() }
    } catch (e: FileNotFoundException) {
        println("Error file path '$path' does not exist")
        exitProcess(2)
    }
}

fun readUserInput(): String {
    print("Enter text: ")
    return readln()
}

fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Error usage: wordcount <stopwords.txt file path>")
        exitProcess(1)
    }

    val stopWordFilePath = args[0]
    val stopWords = readStopWordsFile(stopWordFilePath)
    val wordCount = WordCounter.wordCount(readUserInput(), stopWords)

    println("Number of words: $wordCount")
}