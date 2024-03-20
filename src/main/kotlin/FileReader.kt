import java.nio.file.Files
import java.nio.file.Paths
import kotlin.streams.toList

class FileReader(private val fileName: String) {
    fun readLines(): List<String> {
        val path = Paths.get(javaClass.classLoader.getResource(fileName)?.toURI()
            ?: throw IllegalArgumentException("File not found: $fileName"))
        return Files.lines(path).toList()
    }
}