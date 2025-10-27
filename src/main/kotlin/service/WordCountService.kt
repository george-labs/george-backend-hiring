package service

import interfaces.WordCountInterface
import model.WordCount

class WordCountService: WordCountInterface {
    override fun count(input: String): List<WordCount> {
        val words = Regex("[a-zA-Z]+").findAll(input).map { it.value }.toList()

        return words
            .map { it.toLowerCase() }
            .groupingBy { it }
            .eachCount()
            .map { (word, count) -> WordCount(word,count) }
    }
}