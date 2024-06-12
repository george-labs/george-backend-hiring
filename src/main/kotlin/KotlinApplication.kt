class KotlinApplication(
    private val inputReader: WordsInputReader,
    private val wordsParser: WordsParser,
    private val wordsCountWriter: ConsoleWordsCountWriter,
) {
    fun run() {
        inputReader.read()?.let { input ->
            val words = wordsParser.parse(input)
            wordsCountWriter.write(words.count())
        }
    }
}

fun main(args: Array<String>) {
    val promptPrinter = PromptPrinter()
    val inputReader = if (args.isEmpty()) ConsoleInputReader(promptPrinter) else FileInputReader(args[0])
    val wordsParser = StopWordsSkippingParser()
    val countWriter = ConsoleWordsCountWriter()
    KotlinApplication(inputReader, wordsParser, countWriter).run()
}
