import at.erste.WordCounter
import at.erste.io.ConsoleOutputWriter
import at.erste.io.FileReader
import at.erste.io.OutputWriter
import at.erste.io.ResourceFileReader

fun main(args: Array<String>) {
    print("Enter text:")
    val stringInput = readln()
    // app initialization
    val resourceFileReader = ResourceFileReader()
    val outputWriter = ConsoleOutputWriter()
    val kotlinApplication = KotlinApplication(resourceFileReader, outputWriter)
    // execution
    kotlinApplication.processUserInput(stringInput)
}

class KotlinApplication(private val filesystemFileReader: FileReader, private val outputWriter: OutputWriter) {

    private val skippedWords: List<String> = filesystemFileReader.readByLine("/stopwords.txt")

    fun processUserInput(input: String) {
        val wordCounter = WordCounter(skippedWords)
        outputWriter.write("Number of words: ${wordCounter.countWords(input)}")
    }
}
