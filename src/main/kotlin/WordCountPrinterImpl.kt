import java.io.OutputStream
import java.util.*

class WordCountPrinterImpl(
    private val fileWordParser: FileWordParser,
    private val wordSplitter: WordSplitter,
    private val outputStream: OutputStream
) : WordCountPrinter {

    override fun printNumberOfWords(args: Array<String>, wordsToIgnore: List<String>) {
        val outputStreamWriter = outputStream.writer()
        if (args.isNotEmpty()) {
            val fileName = args[0]
            val inputText = fileWordParser.getWordsFromFile(fileName).joinToString(" ")
            val basicWords = wordSplitter.split(inputText, wordsToIgnore = wordsToIgnore)
            val uniqueWords = basicWords.toSet()

            outputStreamWriter.write("Number of words: ${basicWords.size}, unique: ${uniqueWords.size}")
        } else {
            outputStreamWriter.write("Enter text: ")
            outputStreamWriter.flush()

            val scanner = Scanner(System.`in`)
            val line = scanner.nextLine()

            val basicWords = wordSplitter.split(line, wordsToIgnore = wordsToIgnore)
            val uniqueWords = basicWords.toSet()
            outputStreamWriter.write("Number of words: ${basicWords.size}, unique: ${uniqueWords.size}")
        }
        outputStreamWriter.close()
    }
}
