package inputReader

class ConsoleInputReader(private val readLineImplementation: () -> String, private val printer: (String) -> Unit): InputReader {
    companion object {
        const val entryMessage = "Enter text: "
    }
    override fun read(): String {
        printer(entryMessage)
        return readLineImplementation()
    }
}