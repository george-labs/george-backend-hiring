package at.erste.digital.wordcounter.service

import java.math.BigDecimal
import java.math.RoundingMode

class InputStatisticsService(private val stopWords: List<String> = emptyList()) {
    fun getInputStatistics(text: String): InputTextStatistics {
        val words = getWords(text)

        val averageLength = words
            .takeIf { it.isNotEmpty() }
            ?.map { it.length }
            ?.average()
            ?.let { BigDecimal(it) }
            ?: BigDecimal.ZERO
        return InputTextStatistics(
            wordCount = words.size,
            uniqueWordCount = words.toSet().size,
            averageLength = averageLength.setScale(2, RoundingMode.HALF_UP)
        )
    }

    private fun getWords(text: String): List<String> = text.trim()
        .split(" ", "\t", "\n")
        .filter { it.matches("([a-zA-Z]+[-][a-zA-Z]+)?([a-zA-Z]+)".toRegex()) }
        .filterNot { it in stopWords }
}