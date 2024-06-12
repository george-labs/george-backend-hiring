class WordsParser {
    fun parse(input: String): Iterable<String> {
        val chunkMatcher = "\\S+".toRegex()
        val allowedCharactersMatcher = "[a-zA-Z]+".toRegex()
        return chunkMatcher.findAll(input)
            .map { it.value }
            .filter { allowedCharactersMatcher.matches(it) }
            .asIterable()
    }
}
