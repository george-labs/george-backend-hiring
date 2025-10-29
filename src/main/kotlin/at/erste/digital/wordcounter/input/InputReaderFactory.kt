package at.erste.digital.wordcounter.input

object InputReaderFactory {
    fun getInputReaderBasedOnArguments(programArguments: Array<String>): UserInputReader {
        return when(programArguments.size) {
            1 -> FileInputReader(programArguments[0])
            0 -> StandardInputReader()
            else -> throw RuntimeException("Too many program arguments")
        }
    }
}