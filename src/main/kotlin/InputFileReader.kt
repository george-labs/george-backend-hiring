import java.nio.file.Files
import java.nio.file.Paths

class InputFileReader(private val fileName: String) {

    fun readText(): String {
        val path = Paths.get(fileName)
        if (!Files.exists(path)) {
            throw IllegalArgumentException("File not found: $fileName")
        }
        return Files.readString(path)
    }
    fun readTextFromResources(): String {
        val url = javaClass.classLoader.getResource(fileName)
            ?: throw IllegalArgumentException("Resource not found: $fileName")
        val path = Paths.get(url.toURI())

        if (!Files.exists(path)) {
            throw IllegalArgumentException("File not found: $fileName")
        }
        return String(Files.readAllBytes(path))
    }
}
