import java.io.File
import java.io.InputStream
import java.io.OutputStream

fun main(args: Array<String>) {
    Application(
        stopWordsFile = File("stopwords.txt"),
        textInputStream = System.`in`,
        resultOutputStream = System.out
    ).run()
}

class Application(
    private val stopWordsFile: File,
    private val textInputStream: InputStream,
    private val resultOutputStream: OutputStream,
) {

    fun run() {
        val stopWords = stopWordsFile.readLines().toSet()

        resultOutputStream.bufferedWriter().use { writer ->
            writer.write("Enter text: ")
            writer.flush()
            val inputText = textInputStream.bufferedReader().use { it.readLine() }

            val wordCount = WordCounter(
                stopWords = stopWords
            ).countWordsInInput(inputText)

            writer.write("Number of words: $wordCount\n")
        }
    }
}
