package wordcount

data class WordCountResult(
    val numWords: Int = 0,
    val unique: Int = 0,
    val averageLength: Double = 0.0,
    val index: List<String> = listOf(),
)
