import java.io.File

object KotlinApplication {

    @JvmStatic
    fun main(args: Array<String>) {
        val stopWordFile = File("./stopwords.txt")
        val stopWordsProvider = FileStopWordProvider(stopWordFile)
        val wordCounter = WordCounterImpl(stopWordsProvider)
        val wordCounterInput = WordCounterInput(wordCounter)
        val result = wordCounterInput.process(args.firstOrNull())
        println("Number of words: $result")
    }
}
