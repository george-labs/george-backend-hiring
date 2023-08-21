import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.pathString


class KotlinApplicationKtTest {

    @Test
    fun readStopWordsFile(@TempDir tempDir: Path) {
        val stopWords = tempDir.resolve("stopwords.txt")
        val lines: List<String> = listOf("the  ", "", "  a", "are")
        Files.write(stopWords, lines)

        assert(Files.exists(stopWords)) { "readStopWordsFile: Expected file '$stopWords' does not exist"}

        val got = readStopWordsFile(stopWords.pathString)
        val expected = listOf("the", "a", "are")
        assert(expected == got) { "readStopWordsFile: Expected $expected, Got: $got" }
    }
}