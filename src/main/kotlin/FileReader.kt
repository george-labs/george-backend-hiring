import java.io.File

class FileReader {
    val stopWordFileName = "stopwords.txt"

    fun readStopWords(): List<String> {
        return readFromFile(stopWordFileName)
    }

    private fun readFromFile(fileName: String): List<String> {
        val file = File(fileName)
        val lines = mutableListOf<String>()
        if (file.exists() && file.isFile) {
            lines.addAll(file.readLines())
        }
        return lines
    }
}