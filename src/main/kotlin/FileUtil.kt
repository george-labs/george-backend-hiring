import java.io.File

object FileUtil {

    // tries to read file form filepath returns null if file was not found or cannot be read
    fun readFileFromPath(filePath: String): String? {
        return try {
            val file = File(filePath)
            if (file.exists() && file.canRead()) {
                file.readText()
            } else {
                println("File not found or cannot be read: $filePath")
                null
            }
        } catch (e: Exception) {
            println("Error reading file: $filePath with an exception: $e")
            null
        }
    }

    fun readResourceFile(resourceFileName: String): String {
        return WordCounter::class.java.getResource(resourceFileName)
            ?.readText(Charsets.UTF_8)
            ?: error("Resource not found: $resourceFileName")
    }
}