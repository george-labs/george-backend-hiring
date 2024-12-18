import inputReader.ConsoleInputReader
import inputReader.FileInputReader
import inputReader.InputReader

class InputReaderFactory(private val readLineImplementation: () -> String, private val printer: (String) -> Unit) {

    fun getInputReader(inputTextFileName: String?): InputReader {
        return if (inputTextFileName != null)
            FileInputReader(inputTextFileName)
        else
            ConsoleInputReader(readLineImplementation, printer)
    }
}