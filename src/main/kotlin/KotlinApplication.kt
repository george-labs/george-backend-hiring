import at.erste.WordCounter
import at.erste.io.ConsoleInputReader
import at.erste.io.ConsoleOutputWriter
import at.erste.io.FileReader
import at.erste.io.InputReader
import at.erste.io.OutputWriter
import at.erste.io.ResourceFileReader

fun main(args: Array<String>) {
    // app initialization
    val inputReader = ConsoleInputReader()
    val resourceFileReader = ResourceFileReader()
    val outputWriter = ConsoleOutputWriter()
    val kotlinApplication = KotlinApplication(inputReader, resourceFileReader, outputWriter)
    // execution
    kotlinApplication.processUserInput()
}

class KotlinApplication(private val inputReader: InputReader, private val filesystemFileReader: FileReader, private val outputWriter: OutputWriter) {

    private val skippedWords: List<String> = filesystemFileReader.readByLine("/stopwords.txt")

    fun processUserInput() {
        val userInput = inputReader.readUserInput("Enter text:")
        val wordCounter = WordCounter(skippedWords)
        outputWriter.write("Number of words: ${wordCounter.countWords(userInput)}")
    }
}
