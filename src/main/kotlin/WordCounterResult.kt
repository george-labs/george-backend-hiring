data class WordCounterResult(
    val numberOfWords: Int,
    val unique: Int,
) {

    companion object {

        val ZERO = WordCounterResult(0, 0)
    }
}
