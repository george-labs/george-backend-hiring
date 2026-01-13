package service

private val WORD_REGEX_PATTERN = "[a-zA-Z]+".toRegex()

class WordCounterService {
    fun countWords(text: String): Int {
        return splitWords(text).size
    }

    private fun splitWords(text: String): List<String> {
        return WORD_REGEX_PATTERN.findAll(text).map { it.value }.toList()
    }
}