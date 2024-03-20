import java.nio.file.Files
import java.nio.file.Paths

class StopWordsFileReader(private val fileName: String): IFileReader {
    override fun readLines(): List<String> {
        val path = Paths.get(javaClass.classLoader.getResource(fileName)?.toURI()
            ?: throw IllegalArgumentException("File not found: $fileName"))
        return Files.lines(path).toList()
    }
}
