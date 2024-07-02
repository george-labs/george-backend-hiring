import Counter.SimpleCounter
import InputReader.ImputScanner

class KotlinApplication {

    companion object {
        val resourceTools = ResourceTools()
        val imputScanner = ImputScanner()
        const val STOPWORDS_PATH = "stopwords.txt"
    }

    fun scan() {
        val stopwords = loadStopWords()
        val simpleCounter = SimpleCounter(stopwords)
        print("Enter text: ")
        val count = simpleCounter.count(imputScanner.readText())
        println("Number of words: $count")
    }

    private fun loadStopWords() = resourceTools.readTextFile(STOPWORDS_PATH).split("\n")
}

fun main() {
    val kotlinApplication = KotlinApplication()
    kotlinApplication.scan()
}
