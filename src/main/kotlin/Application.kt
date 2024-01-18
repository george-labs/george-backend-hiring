import java.io.BufferedWriter
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream
import java.io.OutputStream

fun main(args: Array<String>) {
    Application(
        arguments = args,
        stopWordsReader = StopWordsReaderImpl(),
        textInputStream = System.`in`,
        resultOutputStream = System.out
    ).run()
}

class Application(
    private val arguments: Array<String>,
    private val stopWordsReader: StopWordsReader,
    private val textInputStream: InputStream,
    private val resultOutputStream: OutputStream,
) {

    fun run() {
        val stopWords = stopWordsReader.readStopWords()

        resultOutputStream.bufferedWriter().use { writer ->
            val inputText = readInput(writer)

            val wordCount = WordCounter(
                stopWords = stopWords
            ).countWordsInInput(inputText)

            writer.write("Number of words: $wordCount\n")
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
