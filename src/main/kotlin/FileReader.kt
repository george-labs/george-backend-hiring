import java.io.File

interface FileReader {
    fun readFile(filePath: String): String
}

class FileReaderImpl : FileReader {
    override fun readFile(filePath: String): String {
        return File(filePath).readText()
    }
}