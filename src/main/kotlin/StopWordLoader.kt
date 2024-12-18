import java.nio.file.Paths
import kotlin.io.path.readLines

class StopWordLoader(private val stopWordResourceFileName: String) {
    fun loadFromResources(): Set<String> {
        val stopWordsUrl = StopWordLoader::class.java.getResource("/$stopWordResourceFileName")!!
        return Paths.get(stopWordsUrl.toURI()).readLines().toSet()
    }
}