package impl

import WordCounter
import abstract.StopWordsLoader

class StopWordContext : StopWordsLoader {
    private val stopWords: Set<String>

    init {
        stopWords = loadStopwordsFile()
    }

    override fun getStopWords(): Set<String> = stopWords

    private fun loadStopwordsFile(): Set<String> {
        return parseStopwordsFile(readResourceFile("stopwords.txt"))
    }

    private fun parseStopwordsFile(unparsedFileText: String): Set<String> {
        return unparsedFileText.split('\n').toSet()
    }

    private fun readResourceFile(resourceFileName: String): String {
        return WordCounter::class.java.getResource(resourceFileName)
            ?.readText(Charsets.UTF_8)
            ?: error("Resource not found: $resourceFileName")
    }
}