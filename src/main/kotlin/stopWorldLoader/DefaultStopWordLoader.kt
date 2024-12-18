package stopWorldLoader

import java.nio.file.Paths
import kotlin.io.path.readLines

class DefaultStopWordLoader(private val stopWordResourceFileName: String): StopWordLoader {
    override fun loadFromResources(): Set<String> {
        val stopWordsUrl = DefaultStopWordLoader::class.java.getResource("/$stopWordResourceFileName")!!
        return Paths.get(stopWordsUrl.toURI()).readLines().toSet()
    }
}