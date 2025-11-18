import java.io.File
import java.nio.file.Paths

class App() {
    private fun consoleReader() = Reader {
        readln()
    }

    private fun fileReader(fileName: String) = Reader {
        File( Paths.get("").toAbsolutePath().toString() + "\\$fileName").readText()
    }

    val consoleWriter = Writer { output ->
        print(output)
    }

    fun runApp(fileName: String?) {
        val reader = if (fileName == null) {
            consoleReader()
        } else {
            fileReader(fileName)
        }

        mainLoop(reader, consoleWriter)
    }

    internal fun mainLoop(reader: Reader, writer: Writer) {
        val stopWords = this::class.java.getResourceAsStream("stopwords.txt")!!.bufferedReader().readLines()
        val wordCounter = WordCounter(stopWords)
        writer.write("Enter text: ")
        val input = reader.read()
        writer.write("Number of words: ${wordCounter.countWords(input)}")
    }


}