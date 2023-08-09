data class WordCounterResult(
    val numberOfWords: Int,
    val unique: Int,
    val averageWordLength: Double,
) {

    companion object {

        val ZERO = WordCounterResult(0, 0, 0.0)
    }
}
