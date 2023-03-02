import java.math.BigDecimal

data class WordCountReport(val totalCount: Int, val uniqueCount: Int, val averageWordLength: BigDecimal?) {
    override fun toString() =
            "Number of words: $totalCount, unique: $uniqueCount" +
                    "; average word length: ${formatOptionalNumber(averageWordLength)} characters"
}