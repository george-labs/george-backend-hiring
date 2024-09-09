import iteration1.WordCounter
import java.io.File

fun main(args: Array<String>) {
    val wordCounter = WordCounter()

    if(args.isNotEmpty()) {
        val filename = args[0]
        val contents: String? = readFileContents(filename)

        contents?.let {
            printOutput(wordCounter.countWords(it))
        } ?: run {
            println("Unable to read file $filename")
        }
    } else {
        print("Enter text:")

        val input = readlnOrNull()

        printOutput(wordCounter.countWords(input))
    }
}

fun readFileContents(filename: String): String? {
    return try {
        val lines = File(filename).readLines()

        lines.joinToString(" ")
    } catch (e:Exception) {
        null
    }
}

fun printOutput(size:Int) {
    println("Number of words: $size")
}
