import impl.StopWordContext
import java.util.Scanner

class MyApplication

fun main(args: Array<String>) {
    val filePath = args.firstOrNull() // e.g. "input.txt"

    val fileContent = filePath?.let { FileUtil.readFileFromPath(filePath) }

    val userInput = if (fileContent == null) {
        println("Enter text: ")
        val scanner = Scanner(System.`in`)
        scanner.nextLine()
    } else fileContent

    val stopWordContext = StopWordContext()
    val wordCounter = WordCounter(stopWordContext)

    val words = wordCounter.getWordsWithoutStopwords(userInput)
    val uniqueWordCount = wordCounter.countUniqueWords(words)

    println("Number of words: ${words.count()}, unique: $uniqueWordCount")
}