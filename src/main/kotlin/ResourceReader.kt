import java.io.File

interface ResourceReader {
    fun provide(): List<String>
}

class StopWordsReader : ResourceReader {
    override fun provide(): List<String> {
        val resource = object {}.javaClass.getResource("stopwords.txt")
            ?: throw IllegalArgumentException("stopwords.txt not found")

        return File(resource.toURI()).readLines()
    }
}