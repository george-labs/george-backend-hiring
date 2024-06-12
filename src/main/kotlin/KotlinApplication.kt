class KotlinApplication(
    private val inputReader: WordsInputReader,
    private val wordsParser: WordsParser,
    private val wordsCountWriter: ConsoleWordsCountWriter,
    private val uniqueCountWriter: ConsoleUniqueWordsCountWriter,
    private val wordsCounter: WordsCounter,
    private val uniqueWordsCounter: UniqueWordsCounter,
) {
    fun run() {
        inputReader.read()?.let { input ->
            val words = wordsParser.parse(input)
            wordsCountWriter.write(wordsCounter.count(words))
            uniqueCountWriter.write(uniqueWordsCounter.count(words))
        }
    }
}

fun main(args: Array<String>) {
    val promptPrinter = PromptPrinter()
    val inputReader = if (args.isEmpty()) ConsoleInputReader(promptPrinter) else FileInputReader(args[0])
    val wordsParser = StopWordsSkippingParser()
    val countWriter = ConsoleWordsCountWriter()
    val uniqueCountWriter = ConsoleUniqueWordsCountWriter()
    val wordsCounter = WordsCounter()
    val uniqueWordsCounter = UniqueWordsCounter()

    KotlinApplication(inputReader, wordsParser, countWriter, uniqueCountWriter, wordsCounter, uniqueWordsCounter).run()
}
