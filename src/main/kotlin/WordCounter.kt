import counter.CounterInterface
import counter.SimpleCounter
import InputReader.InputScanner
import InputReader.TextFileReader

class WordCounter(private val wordsFilePath: String = "") {

    companion object {
        val imputScanner = InputScanner(System.`in`)
        const val STOPWORDS_PATH = "stopwords.txt"
    }

    fun scan() {
        val stopwords = loadStopWords()
        val simpleCounter = SimpleCounter(stopwords)
        if (wordsFilePath.isEmpty()) {
            executeCount(simpleCounter, loadUserInput())
        } else {
            executeCount(simpleCounter, loadInputFromFile(wordsFilePath))
        }
    }

    fun loadUserInput(): String {
        print("Enter text: ")
        return imputScanner.readText()
    }

    fun loadInputFromFile(wordsFilePath: String): String {
        val textFileReader = TextFileReader(wordsFilePath)
        return textFileReader.readText()
    }

    fun executeCount(counter: CounterInterface, input: String) {
        val result = counter.count(input)
        println(result)
    }

    private fun loadStopWords(): List<String> {
        val textFileReader = TextFileReader(STOPWORDS_PATH)
        return textFileReader.readText().split("\n")
    }
}