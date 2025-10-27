package service

import interfaces.WordCountInterface
import model.WordCount
import java.io.File
import java.util.Locale
import java.util.Locale.getDefault

class WordCountService(stopWordFile: File) : WordCountInterface {
    override fun count(input: String): List<WordCount> {
        val words = Regex("[a-zA-Z]+").findAll(input).map { it.value }.toList()

        return words
            .map { it.lowercase(getDefault())}
            .filterNot { stopWord.contains(it) }
            .groupingBy { it }
            .eachCount()
            .map { (word, count) -> WordCount(word,count) }
    }

    val stopWord = parseStopWordFile(stopWordFile)
    override fun parseStopWordFile(file: File) :Set<String>{
        return if (file.exists()){
            file.readLines()
                .map { it.lowercase(getDefault()) }
                .filter {  it.isNotBlank() }
                .toSet()
        }else
            emptySet()
    }


}