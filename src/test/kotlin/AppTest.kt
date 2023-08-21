import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.io.TempDir
import java.io.FileNotFoundException
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
        assert(expected == got) { "App.readTextFile: Expected $expected, Got: $got" }
    }

    @Test
    fun testReadTextFileThrowsFileNotFoundException() {
        val args = listOf("mytest.txt")
        val exception = assertThrows<FileNotFoundException> {
            App(args).readTextFile()
        }
        val expected = "Error file path 'mytest.txt' does not exist"
        val got = exception.message

        assert(expected == got) { "App.readTextFile: Expected $expected, Got: $got" }
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

    @Test
    fun testReadStopWordsFileThrowsFileNotFoundException() {
        // Note: implementation requires us to pass mytext.txt file
        // because usage is like this wordcount [mytext.txt] [stopwords.txt]
        val args = listOf("mytest.txt", "stopwords.txt")
        val exception = assertThrows<FileNotFoundException> {
            App(args).readStopWordsFile()
        }
        val expected = "Error file path 'stopwords.txt' does not exist"
        val got = exception.message

        assert(expected == got) { "App.readStopWordsFile: Expected $expected, Got: $got" }
    }

    @Test
    fun testAppConstructorThrowsInvalidNumberOfArgsException() {
        val args = listOf("mytest.txt", "stopwords.txt", "anotherfile.txt")
        val exception = assertThrows<InvalidNumberOfArgsException> {
            App(args)
        }
        val expected = "Error usage: wordcount [mytext.txt] [stopwords.txt]"
        val got = exception.message

        assert(expected == got) { "App.init: Expected $expected, Got: $got" }
    }
}