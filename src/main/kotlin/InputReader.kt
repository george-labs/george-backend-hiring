import java.io.File

interface InputReader {
    fun read(): String
}


class StdinInputReader : InputReader {
    override fun read(): String {
        print("Enter text:")
        return readlnOrNull().orEmpty()
    }
}

class FileInputReader(private val fileName: String): InputReader {
    override fun read(): String {
        return File(fileName).readLines().joinToString(" ")
    }
}

