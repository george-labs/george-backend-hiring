import java.io.File

const val DEFAULT_STOPWORDS_FILE_NAME = "stopwords.txt"

class StopWordsSkippingParser(private val filename: String = DEFAULT_STOPWORDS_FILE_NAME) : SimpleWordsParser() {
    override fun parse(input: String): Iterable<String> {
        val stopWords = readStopWordsFromFile()

        return super.parse(input).minus(stopWords.toSet())
    }

    private fun readStopWordsFromFile(): Iterable<String> = File(filename).readLines()
}
