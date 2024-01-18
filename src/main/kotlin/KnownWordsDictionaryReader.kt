import java.io.IOException
import java.nio.file.Path
import kotlin.io.path.readLines

interface KnownWordsDictionaryReader {
    fun readFromPath(dictionaryPath: Path): Set<String>
}

class KnownWordsDictionaryReaderImpl : KnownWordsDictionaryReader {

    override fun readFromPath(dictionaryPath: Path): Set<String> {
        return try {
            dictionaryPath.readLines().toSet()
        } catch (e: IOException) {
            throw IllegalArgumentException("Failed reading known words dictionary at path ${dictionaryPath}.", e)
        }
    }

}
