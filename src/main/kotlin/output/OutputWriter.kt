package output

import wordcount.WordCountResult

class OutputWriter(
    private val printer: Printer = CmdPrinter()
) {

    fun writeOutput(result: WordCountResult) {
        val (numWords, words, averageLength) = result
        printer.print("Number of words: $numWords, unique: $words; average word length: ${"%.2f".format(averageLength)} characters")
    }
}