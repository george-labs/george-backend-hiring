import java.io.File

class FileReader {
    fun readFile(filePath: String): String {
        val file = File(filePath).readText()
        return file
    }
}