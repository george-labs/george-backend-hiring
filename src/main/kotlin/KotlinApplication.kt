class KotlinApplication(
    private val promptPrinter: PromptPrinter,
    private val inputReader: ConsoleInputReader,
    private val wordsParser: WordsParser,
    private val wordsCountWriter: ConsoleWordsCountWriter,
) {
    fun run() {
        promptPrinter.hello()
        inputReader.read()?.let { input ->
            val words = wordsParser.parse(input)
            wordsCountWriter.write(words.count())
        }
    }
}

fun main() {
    val promptPrinter = PromptPrinter()
    val inputReader = ConsoleInputReader()
    val wordsParser = WordsParser()
    val countWriter = ConsoleWordsCountWriter()
    KotlinApplication(promptPrinter, inputReader, wordsParser, countWriter).run()
}
