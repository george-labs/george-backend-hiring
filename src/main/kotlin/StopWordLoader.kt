import java.nio.file.Path

class StopWordLoader() {
    fun loadFromResources(resourceName: String): List<String> {
        // handle reading line by line
        val stopWordsText = StopWordLoader::class.java.getResource("resourceName").readText()
        return stopWordsText.split("\n")
    }
}