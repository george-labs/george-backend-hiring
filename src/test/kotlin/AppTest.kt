import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.pathString


class AppTest {

    @Test
    fun testReadTextFile(@TempDir tempDir: Path) {
        val myTexts = tempDir.resolve("mytext.txt")
        val lines: List<String> = listOf("cat  ", "", "  is", "at", "the", "door no", "3")
        Files.write(myTexts, lines)

        assert(Files.exists(myTexts)) { "readTextFile: Expected file '$myTexts' does not exist"}

        val args = listOf(myTexts.pathString)
        val got = App(args).readTextFile()
        val expected = listOf("cat", "is", "at", "the", "door no", "3")
        assert(expected == got) { "readStopWordsFile: Expected $expected, Got: $got" }
    }
}