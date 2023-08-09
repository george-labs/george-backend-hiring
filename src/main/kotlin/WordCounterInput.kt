import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.text.DecimalFormat

class WordCounterInput(private val wordFilter: WordFilter) {

    private val wordCounter = WordsCounterConsumer()
    private val wordAverage = WordsAverageConsumer()
    private val wordUnique = WordsUniqueConsumer()
    private val wordsIndex = WordsIndexConsumer()

    fun process(inputFile: String? = null) {
        val inputString = if (inputFile == null) {
            println("Enter text: ")
            BufferedReader(InputStreamReader(System.`in`)).use {
                it.readLine()
            }
        } else {
            File(inputFile).readText().replace("\n", " ")
        }
        printResults(inputString, false)
    }

    fun processWithIndex() {
        println("Enter text: ")
        val inputString = BufferedReader(InputStreamReader(System.`in`)).use {
            it.readLine()
        }
        printResults(inputString, true)
    }

    private fun printResults(input: String, index: Boolean) {
        val words = wordFilter.filter(input)
        val result = buildString {
            append("Number of words: ")
            append(wordCounter.accept(words))
            append(" , unique: ")
            append(wordUnique.accept(words))
            append("; average word length: ")
            append(FORMATTER.format(wordAverage.accept(words)))
            if (index) {
                appendLine()
                appendLine("Index:")
                val indexedWords = wordsIndex.accept(words)
                indexedWords.forEach { appendLine(it) }
            }
        }
        println(result)
    }

    companion object {
        val FORMATTER = DecimalFormat("#.##")
    }
}
