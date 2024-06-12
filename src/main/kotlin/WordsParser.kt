fun interface WordsParser {
    fun parse(input: String): Iterable<String>
}
