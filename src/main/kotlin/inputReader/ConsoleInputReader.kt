package inputReader

class ConsoleInputReader(private val readLineImplementation: () -> String, private val printerImplementation: (String) -> Unit): InputReader {
    companion object {
        const val entryMessage = "Enter text: "
    }
    override fun read(): String {
        printerImplementation(entryMessage)
        return readLineImplementation()
    }
}