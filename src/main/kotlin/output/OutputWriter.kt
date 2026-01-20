package output

import wordcount.WordCountResult

class OutputWriter(
    private val printer: Printer = CmdPrinter()
) {

    fun writeOutput(result: WordCountResult, includeIndex: Boolean = false) {
        val (numWords, words, averageLength, index) = result
        printer.print("Number of words: $numWords, unique: $words; average word length: ${"%.2f".format(averageLength)} characters")

        if (includeIndex) {
            printer.print("Index:")
            index.sorted().forEach { printer.print(it) }
        }
    }
}