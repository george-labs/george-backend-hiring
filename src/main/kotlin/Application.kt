
fun main(args: Array<String>) {
    System.out.bufferedWriter().use { outputWriter ->
        Application(
            inputTextReader = InputTextReaderImpl(
                arguments = args,
                textInputStream = System.`in`,
                writer = outputWriter
            ),
            stopWordsReader = ClasspathStopWordsReader(),
            resultWriter = StreamResultWriter(
                writer = outputWriter
            )
        ).run()
    }
}

class Application(
    private val inputTextReader: InputTextReader,
    private val stopWordsReader: StopWordsReader,
    private val resultWriter: ResultWriter,
) {

    fun run() {
        // Input
        val stopWords = stopWordsReader.readStopWords()
        val inputText = inputTextReader.readInput()

        // Processing
        val wordCounter = WordCounter(stopWords)
        val wordCountResult = wordCounter.countWordsInText(inputText)

        // Output
        resultWriter.write(wordCountResult)
    }

}
