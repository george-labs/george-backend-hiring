import inputReader.FileInputReader
import inputReader.InputReader

// change name of the class
class ApplicationController(val inputTextFileName: String?, val stopWordLoader: StopWordLoader, val inputReaders: List<InputReader>) {
    fun countWords(): Int {
        if (inputTextFileName != null)
            val reader = inputReaders.single { it is FileInputReader }
            reader.read()
        else {

        }

    }
}