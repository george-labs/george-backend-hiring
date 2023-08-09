import java.io.File
import java.text.DecimalFormat

object KotlinApplication {

    @JvmStatic
    fun main(args: Array<String>) {
        val stopWordFile = File("./stopwords.txt")
        val stopWordsProvider = FileStopWordProvider(stopWordFile)
        val wordCounter = WordCounterImpl(stopWordsProvider)
        val wordCounterInput = WordCounterInput(wordCounter)
        val result = wordCounterInput.process(args.firstOrNull())
        val formatter = DecimalFormat("#.##")
        println(
            "Number of words: ${result.numberOfWords} , unique: ${result.unique}; average word length: ${
                formatter.format(
                    result.averageWordLength
                )
            } characters"
        )
    }
}
