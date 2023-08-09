import java.io.File

object KotlinApplication {

    @JvmStatic
    fun main(args: Array<String>) {
        val stopWordFile = File("./stopwords.txt")
        val stopWordsProvider = FileStopWordProvider(stopWordFile)
        val wordFilter = WordFilterImpl(stopWordsProvider)
        val wordCounterInput = WordCounterInput(wordFilter)
        val firstParam = args.firstOrNull()
        if (firstParam == "-index") {
            wordCounterInput.processWithIndex()
        } else {
            wordCounterInput.process(firstParam)
        }
    }
}
