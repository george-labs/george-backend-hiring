import java.io.File

interface ResourceReader {
    fun provide(): List<String>
}

const val FILENAME = "stopwords.txt"

class StopWordsReader(private val fileName: String) : ResourceReader {
    override fun provide(): List<String> {
        val resource = object {}.javaClass.getResource(fileName)
            ?: throw IllegalArgumentException("$fileName not found")

        return File(resource.toURI()).readLines()
    }
}