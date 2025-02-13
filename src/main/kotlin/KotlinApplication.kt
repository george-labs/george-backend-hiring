import impl.StopWordContext
import java.io.File
import java.util.Scanner

class MyApplication

fun main(args: Array<String>) {
    val filePath = args.firstOrNull() // e.g. "input.txt"
    // If a file path is provided as an argument, try loading it
    var fileContent: String? = null
    if (!filePath.isNullOrBlank()) {
        val file = File(filePath)
        if (file.exists() && file.canRead()) {
            fileContent = file.readText()
        } else {
            println("File not found or cannot be read. Falling back to user input.")
        }
    } else {
        println("No file argument provided. Falling back to user input.")
    }
//    fileContent?.let {  (fileContent == null) {
//        println("Enter text: ")
//        val scanner = Scanner(System.`in`)
//        val userInput = scanner.nextLine()
//    }
//    }

    val stopWordContext = StopWordContext()
    val wordCount = WordCounter(stopWordContext).countWords(userInput)

    println("Number of words: $wordCount")
}