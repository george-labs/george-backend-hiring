import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.pathString

class ReadFileTest {
    @Test
    fun readLines(@TempDir tempDir: Path) {
        val stopWords = tempDir.resolve("stopwords.txt")
        val lines: List<String> = listOf("the  ", "", "  a", "are")
        Files.write(stopWords, lines)

        val file: FileReader = ReadFile(stopWords.pathString)
        val got = file.readLines()
        val expected = listOf("the  ", "", "  a", "are")
        assert(expected == got) { "readStopWordsFile: Expected $expected, Got: $got" }
    }
}