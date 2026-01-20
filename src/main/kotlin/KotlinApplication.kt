import output.OutputWriter
import reader.CmdReader
import wordcount.Stopwords
import wordcount.WordCounter
import wordcount.WordCounterConfig
import wordcount.WordInput

object KotlinApplication {

    @JvmStatic
    fun main(args: Array<String>) {

        val stopwords = Stopwords.fromResource("stopwords.txt")

        val wordInput = WordInput.fromArguments(args, CmdReader())

        val wordCounterConfig = WordCounterConfig("[^A-Za-z-]+")
        val wordCounter = WordCounter(stopwords, wordCounterConfig)

        val result = wordCounter.countWords(wordInput.input)

        OutputWriter().writeOutput(result, wordInput.includeIndex)
    }
}