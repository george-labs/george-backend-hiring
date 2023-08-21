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

        assert(Files.exists(myTexts)) { "App.readTextFile: Expected file '$myTexts' does not exist"}

        val args = listOf(myTexts.pathString)
        val got = App(args).readTextFile()
        val expected = listOf("cat", "is", "at", "the", "door no", "3")
        assert(expected == got) { "App.readStopWordsFile: Expected $expected, Got: $got" }
    }

    @Test
    fun testReadStopWordsFile(@TempDir tempDir: Path) {
        val stopWords = tempDir.resolve("stopwords.txt")
        val lines: List<String> = listOf("a", "", "  the")
        Files.write(stopWords, lines)

        assert(Files.exists(stopWords)) { "App.readStopWordsFile: Expected file '$stopWords' does not exist"}

        // Note: implementation requires us to pass mytext.txt file
        // because usage is like this wordcount [mytext.txt] [stopwords.txt]
        val args = listOf("mytext.txt", stopWords.pathString)
        val got = App(args).readStopWordsFile()
        val expected = listOf("a", "the")
        assert(expected == got) { "App.readStopWordsFile: Expected $expected, Got: $got" }
    }
}