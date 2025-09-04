package com.erste.interview.logic

import java.math.BigDecimal
import java.math.BigDecimal.ROUND_UP
import java.math.RoundingMode

class WordCounter {

    private val regex = Regex("[a-zA-Z-]+")

    fun count(text: String, stopWords: Set<String>): CountResult {
        val filteredWords = filterWords(text, stopWords)
        val avgLength = if (filteredWords.isNotEmpty()) {
            filteredWords.sumOf { it.length }.toBigDecimal().divide(filteredWords.size.toBigDecimal(), 2, RoundingMode.UP)
        } else {
            0.0.toBigDecimal()
        }
        return CountResult(
            wordCount = filteredWords.size,
            uniqueCount = filteredWords.toSet().size,
            avgLength = avgLength.setScale(2),
        )
    }

    private fun filterWords(text: String, stopWords: Set<String>): List<String> {
        return text.split(Regex("\\s+"))
            .filter { regex.matches(it) }
            .filterNot { stopWords.contains(it) }
            .filterNot { it.startsWith("-") || it.endsWith("-")}
    }

}