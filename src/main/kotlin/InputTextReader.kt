import java.io.BufferedWriter
import java.io.File
import java.io.InputStream

interface InputTextReader {

    /**
     * @param writer Used to ask user for input if none is provided.
     * @return Read input text from file or stdin.
     */
    fun readInput(writer: BufferedWriter): String
}

class InputTextReaderImpl(
    private val arguments: Array<String>,
    private val textInputStream: InputStream
): InputTextReader {

    override fun readInput(writer: BufferedWriter): String {
        return when (arguments.size) {
            0 -> {
                writer.write("Enter text: ")
                writer.flush()

                textInputStream.bufferedReader().use { it.readLine() }
            }

            // First argument should be input filename
            1 -> {
                File(arguments.first()).readText()
            }

            else -> throw IllegalArgumentException("Expected at most 1 argument (path to file to count words from).")
        }
    }

}