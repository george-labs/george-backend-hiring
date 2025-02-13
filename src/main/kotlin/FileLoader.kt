object FileLoader {
    val stopWords: List<String>

    init {
        stopWords = loadStopwordsFile()
    }

    private fun loadStopwordsFile(): List<String> {
        return parseStopwordsFile(readResourceFile("stopwords.txt"))
    }

    fun readResourceFile(resourceFileName: String): String {
        return WordCounter::class.java.getResource(resourceFileName)
            ?.readText(Charsets.UTF_8)
            ?: error("Resource not found: $resourceFileName")
    }

    fun parseStopwordsFile(unparsedFileText: String): List<String> {
        return unparsedFileText.split('\n')
    }
}