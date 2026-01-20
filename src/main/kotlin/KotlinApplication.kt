import wordcount.Stopwords
import wordcount.WordCounter

object KotlinApplication {

    @JvmStatic
    fun main(args: Array<String>) {
        val stopwords = Stopwords.fromResource("stopwords.txt")
        val wordCounter = WordCounter(stopwords)

        val input = readInput()

        val wordCount = wordCounter.countWords(input)

        printOutput(wordCount)
    }

    fun readInput(): String {
        println("Enter text:")
        return readLine() ?: throw Exception("Input can't be empty")
    }

    fun printOutput(wordCount: Int) {
        println("Number of words: $wordCount")
    }

}