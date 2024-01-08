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
            val basicWords = basicWordCounter.count(inputText, wordsToIgnore = wordsToIgnore)
            val uniqueWords = basicWords.toSet()

            outputStreamWriter.write("Number of words: ${basicWords.size}, unique: ${uniqueWords.size}")
        } else {
            outputStreamWriter.write("Enter text: ")
            outputStreamWriter.flush()

            val scanner = Scanner(System.`in`)
            val line = scanner.nextLine()

            val basicWords = basicWordCounter.count(line, wordsToIgnore = wordsToIgnore)
            val uniqueWords = basicWords.toSet()
            outputStreamWriter.write("Number of words: ${basicWords.size}, unique: ${uniqueWords.size}")
        }
        outputStreamWriter.close()
    }
}
