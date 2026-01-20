package output

import wordcount.WordCountResult

class OutputWriter {

    fun writeOutput(result: WordCountResult) {
        val (numWords, words) = result
        println("Number of words: $numWords, unique: $words")
    }
}