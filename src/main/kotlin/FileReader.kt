import extensions.getDividedWords
import java.io.File

class FileReader {
    val stopWordFileName = "stopwords.txt"

    fun readStopWords(): List<String>? {
        return readFromFile(stopWordFileName)
    }

    private fun readFromFile(fileName: String): List<String>? {
        val file = getResourceAsText(fileName)
        return file?.lines()
    }

    private fun getResourceAsText(path: String): String? =
        object {}.javaClass.getResource(path)?.readText()
}