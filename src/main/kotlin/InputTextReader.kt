import java.io.File
import java.io.InputStream
import java.io.Writer

interface InputTextReader {

    fun readInput(): String
}

/**
 * @param arguments Command line arguments that specify how the input should be read
 * @param textInputStream Input stream to read input if no file is specified in the arguments
 * @param writer Used to ask user for input if none is provided.
 * @return Read input text from file or stdin.
 */
class InputTextReaderImpl(
    private val arguments: Array<String>,
    private val textInputStream: InputStream,
    private val writer: Writer,
): InputTextReader {

    override fun readInput(): String {
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