import wordcount.Stopwords
import wordcount.WordCounter
import wordcount.WordInput

object KotlinApplication {

    @JvmStatic
    fun main(args: Array<String>) {
        val stopwords = Stopwords.fromResource("stopwords.txt")

        val wordInput = WordInput.fromFileOrCmd(args.firstOrNull())

        val wordCounter = WordCounter(stopwords)

        val wordCount = wordCounter.countWords(wordInput.input)

        printOutput(wordCount)
    }

    fun printOutput(wordCount: Int) {
        println("Number of words: $wordCount")
    }
}