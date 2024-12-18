package inputReader

import java.nio.file.Paths
import kotlin.io.path.readBytes
import kotlin.io.path.readLines
import kotlin.io.path.readText

class FileInputReader(private val inputTextFileName: String): InputReader {
    override fun read(): String {
        val file = Paths.get(inputTextFileName)
        val text = file.readLines().joinToString("\n")
        if (text.isBlank())
            return ""
        return text
    }
}