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
    val wordCount = WordCounter(stopWordContext).countWords(userInput)
    // TODO refactor
    val uniqueWordCount = WordCounter(stopWordContext).countWords(userInput)

    println("Number of words: $wordCount, unique: $uniqueWordCount")
}