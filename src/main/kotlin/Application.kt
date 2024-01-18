import java.io.BufferedWriter
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream
import java.io.OutputStream

fun main(args: Array<String>) {
    // We need to load the file as stream, because when using certain bundling methods (e.g., .jar)
    // files from resources cannot be treated as normal file system files and need to be read
    // using streams.
    Application::class.java.classLoader.getResourceAsStream("stopwords.txt").use { stopWordsStream ->
        Application(
            arguments = args,
            // As part of the requirements, if the stopwords file is not present for some reason
            // (even though it should be bundled with application), we should ignore it.
            stopWordsStream = stopWordsStream ?: InputStream.nullInputStream(),
            textInputStream = System.`in`,
            resultOutputStream = System.out
        ).run()
    }
}

class Application(
    private val arguments: Array<String>,
    private val stopWordsStream: InputStream,
    private val textInputStream: InputStream,
    private val resultOutputStream: OutputStream,
) {

    fun run() {
        val stopWords = readStopWords()

        resultOutputStream.bufferedWriter().use { writer ->
            val inputText = readInput(writer)

            val wordCount = WordCounter(
                stopWords = stopWords
            ).countWordsInInput(inputText)

            writer.write("Number of words: $wordCount\n")
        }
    }

    private fun readStopWords(): Set<String> {
        return try {
            stopWordsStream.bufferedReader().readLines().toSet()
        } catch (e: FileNotFoundException) {
            throw RuntimeException("Expected stopwords.txt file to be present and contain line delimited list of stop words.")
        }
    }

    private fun readInput(writer: BufferedWriter): String {
        return when (arguments.size) {
            0 -> {
                writer.write("Enter text: ")
                writer.flush()

                textInputStream.bufferedReader().use { it.readLine() }
            }

            // First argument should be input filename
            1 -> {
                File(arguments.first()).readText()
            }

            else -> throw IllegalArgumentException("Expected at most 1 argument (path to file to count words from).")
        }
    }
}
