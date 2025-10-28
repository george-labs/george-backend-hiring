import java.io.File

fun main(args: Array<String>) {
    val fileReader = FileReader()

    val input = if (args.isNotEmpty()) {
        fileReader.readFile(args[0])
    } else {
        println("Enter your text:")
        readlnOrNull() ?: ""
    }

    val wordCount = WordCounter(fileReader).countWords(input)

    println("Word count: $wordCount")
}