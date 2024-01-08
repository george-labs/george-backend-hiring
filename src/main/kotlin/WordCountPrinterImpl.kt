import java.io.OutputStream
import java.util.*

class WordCountPrinterImpl(
    private val wordParser: WordParser,
    private val basicWordCounter: BasicWordCounter,
    private val outputStream: OutputStream
) : WordCountPrinter {

    override fun printNumberOfWords(args: Array<String>, wordsToIgnore: List<String>) {
        val outputStreamWriter = outputStream.writer()
        if (args.isNotEmpty()) {
            val fileName = args[0]
            val inputText = wordParser.getWordsFromFile(fileName).joinToString(" ")
            outputStreamWriter.write("Number of words: ${basicWordCounter.count(inputText, wordsToIgnore = wordsToIgnore)}")
        } else {
            outputStreamWriter.write("Enter text: ")
            outputStreamWriter.flush()

            val scanner = Scanner(System.`in`)
            val line = scanner.nextLine()

            outputStreamWriter.write("Number of words: ${basicWordCounter.count(line, wordsToIgnore = wordsToIgnore)}")
        }
        outputStreamWriter.close()
    }
}
