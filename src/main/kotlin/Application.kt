import java.io.OutputStream

fun main(args: Array<String>) {
    Application(
        inputTextReader = InputTextReaderImpl(
            arguments = args,
            textInputStream = System.`in`,
        ),
        stopWordsReader = ClasspathStopWordsReader(),
        resultOutputStream = System.out
    ).run()
}

class Application(
    private val inputTextReader: InputTextReader,
    private val stopWordsReader: StopWordsReader,
    private val resultOutputStream: OutputStream,
) {

    fun run() {
        val stopWords = stopWordsReader.readStopWords()
        val wordCounter = WordCounter(
            stopWords = stopWords
        )

        resultOutputStream.bufferedWriter().use { writer ->
            val inputText = inputTextReader.readInput(writer)
            val wordCountResult = wordCounter.countWordsInText(inputText)
            writer.write("Number of words: ${wordCountResult.wordCount}, unique: ${wordCountResult.uniqueWords}\n")
        }
    }

}
