fun main(args: Array<String>) {
    System.out.bufferedWriter().use { outputWriter ->
        Application(
            inputTextReader = InputTextReaderImpl(
                arguments = args,
                textInputStream = System.`in`,
                writer = outputWriter
            ),
            stopWordsReader = ClasspathStopWordsReader(),
            knownWordsDictionaryReader = KnownWordsDictionaryReaderImpl(),
            resultWriter = StreamResultWriter(
                indexWriter = StreamIndexWriter(outputWriter),
                writer = outputWriter,
            )
        ).run()
    }
}

class Application(
    private val inputTextReader: InputTextReader,
    private val stopWordsReader: StopWordsReader,
    private val knownWordsDictionaryReader: KnownWordsDictionaryReader,
    private val resultWriter: ResultWriter,
) {

    fun run() {
        // Input
        val stopWords = stopWordsReader.readStopWords()
        val readerResult = inputTextReader.readInput()
        val knownWordsDictionary = readerResult.knownWordsDictionary?.let {
            knownWordsDictionaryReader.readFromPath(it)
        }

        // Processing
        val wordCounter = WordCounterImpl(stopWords)
        val wordCountResult = wordCounter.countWordsInText(
            text = readerResult.inputText,
            buildIndex = readerResult.indexFlag
        )

        // Output
        resultWriter.write(
            wordCountResult = wordCountResult,
            knownWordsDictionary = knownWordsDictionary
        )
    }

}
