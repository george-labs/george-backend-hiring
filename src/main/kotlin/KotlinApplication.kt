import output.OutputWriter
import reader.CmdReader
import wordcount.Stopwords
import wordcount.WordCounter
import wordcount.WordInput

object KotlinApplication {

    @JvmStatic
    fun main(args: Array<String>) {

        val stopwords = Stopwords.fromResource("stopwords.txt")

        val wordInput = WordInput.fromFileOrCmd(args.firstOrNull(), CmdReader())

        val wordCounter = WordCounter(stopwords)

        val result = wordCounter.countWords(wordInput.input)

        OutputWriter().writeOutput(result)
    }
}