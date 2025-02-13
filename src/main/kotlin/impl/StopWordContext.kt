package impl

import FileUtil
import abstract.StopWordsLoader

class StopWordContext : StopWordsLoader {
    private val stopWords: Set<String>

    init {
        stopWords = loadStopwordsFile()
    }

    override fun getStopWords(): Set<String> = stopWords

    private fun loadStopwordsFile(): Set<String> {
        return parseStopwordsFile(FileUtil.readResourceFile("stopwords.txt"))
    }

    private fun parseStopwordsFile(unparsedFileText: String): Set<String> {
        return unparsedFileText.split('\n').toSet()
    }
}