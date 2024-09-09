import iteration1.WordCounter
import java.io.File


fun main(args: Array<String>) {
    val wordCounter = WordCounter()

    if(args.isNotEmpty()) {
        val filename = args[0]
        val contents: String? = readFileContents(filename)

        contents?.let {
            printOutput(wordCounter.countWords(it), wordCounter.countUniqueWords(it))
        } ?: run {
            println("Unable to read file $filename")
        }
    } else {
        print("Enter text:")

        val content = readlnOrNull()

        printOutput(wordCounter.countWords(content), wordCounter.countUniqueWords(content))
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

fun printOutput(number: Int, unique:Int) {
    println("Number of words: $number, unique: $unique")
}
