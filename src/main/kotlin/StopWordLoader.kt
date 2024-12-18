import java.nio.file.Paths
import kotlin.io.path.readLines

class StopWordLoader() {
    fun loadFromResources(resourceName: String): Set<String> {
        val stopWordsUrl = StopWordLoader::class.java.getResource("/$resourceName")!!
        return Paths.get(stopWordsUrl.toURI()).readLines().toSet()
    }
}