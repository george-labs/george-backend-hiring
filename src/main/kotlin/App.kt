import java.io.File

class App() {
    fun mainLoop(reader: Reader, writer: Writer, ) {
        val stopWords = this::class.java.getResourceAsStream("stopwords.txt")!!.bufferedReader().readLines()
        val wordCounter = WordCounter(stopWords)
        writer.write("Enter text: ")
        val input = reader.read()
        writer.write("Number of words: ${wordCounter.countWords(input)}")
    }
}