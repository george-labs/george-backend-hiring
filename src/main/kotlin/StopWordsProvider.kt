import java.io.File
import java.nio.file.Files

interface StopWordsProvider {

    fun isBanned(input: String): Boolean
}

class FileStopWordProvider(
    file: File
) : StopWordsProvider {

    private val words: Set<String> = Files.readAllLines(file.toPath()).toSet()

    override fun isBanned(input: String): Boolean = words.contains(input)
}

class EmptyStopWordsProvider : StopWordsProvider {

    override fun isBanned(input: String): Boolean = false
}
