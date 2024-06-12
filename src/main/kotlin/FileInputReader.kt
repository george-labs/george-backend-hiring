import java.io.File

class FileInputReader(private val filename: String) : WordsInputReader {
    override fun read(): String? {
        val file = File(filename)
        return if (file.exists()) file.readText() else null
    }
}
