class ConsoleInputReader(private val promptPrinter: PromptPrinter) : WordsInputReader {
    override fun read(): String? = promptPrinter.hello().let { readlnOrNull() }
}
