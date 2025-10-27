package service

import interfaces.WordCountInterface
import model.WordCount
import java.io.File
import java.util.Locale.getDefault

class WordCountService(stopWordFile: File) : WordCountInterface {
    override fun collectWordCountElements(input: String): List<WordCount> {
        val words = Regex("[a-zA-Z]+").findAll(input).map { it.value }.toList()

        return words
            .map { it.lowercase(getDefault()) }
            .filterNot { stopWord.contains(it) }
            .groupingBy { it }
            .eachCount()
            .map { (word, count) -> WordCount(word, count) }
    }

    val stopWord = parseWordFile(stopWordFile)
    override fun parseWordFile(file: File): Set<String> {
        return if (file.exists()) {
            file.readLines()
                .map { it.lowercase(getDefault()) }
                .filter { it.isNotBlank() }
                .toSet()
        } else
            throw Error("File was not found:$file")
    }

    override fun collectTotalNrOfElements(result: List<WordCount>): Int {
        return result.sumOf { it.count }
    }

    override fun collectUniqueNrOfElements(result: List<WordCount>): Int {
        return result.count()
    }


}