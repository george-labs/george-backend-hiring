package at.erste.digital.wordcounter.service

import java.math.BigDecimal

data class InputTextStatistics(
    val wordCount: Int,
    val uniqueWordCount: Int,
    val averageLength: BigDecimal
)
