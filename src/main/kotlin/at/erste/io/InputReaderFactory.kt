package at.erste.io

class InputReaderFactory {
    fun createInputReader(fileName: String?): InputReader {
        return if (fileName != null) {
            FileInputReader(fileName)
        } else {
            ConsoleInputReader()
        }
    }
}
