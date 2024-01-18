import java.io.File
import java.io.InputStream
import java.io.Writer
import java.nio.file.Path
import kotlin.io.path.Path

interface InputTextReader {

    fun readInput(): Result

    data class Result(
        val inputText: String,
        /** True when `-index` flag is present in the arguments */
        val indexFlag: Boolean,
        /** Path to the dictionary of known words that index should be verified against */
        val knownWordsDictionary: Path?,
    )
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
) : InputTextReader {

    private val indexFlag = "-index"
    private val dictionaryFlag = "-dictionary"

    override fun readInput(): InputTextReader.Result {
        // For ease of implementation, we will remove all flags we find
        // from the arguments array, before trying to read input text.
        val inputText = getInputText(
            processedArguments = arguments
                .filter { it != indexFlag && !it.startsWith(dictionaryFlag) }
        )

        val knownWordsDictionaryPath = getKnownWordsDictionaryPath()

        return InputTextReader.Result(
            inputText = inputText,
            indexFlag = arguments.contains(indexFlag),
            knownWordsDictionary = knownWordsDictionaryPath
        )
    }

    private fun getKnownWordsDictionaryPath(): Path? {
        return arguments
            .find { it.startsWith(dictionaryFlag) } // -dictionary=path=foo/bar
            ?.split("=")
            ?.drop(1) // [path, foo/bar]
            ?.joinToString("=") // path=foo/bar
            ?.let { Path(it) }
    }

    private fun getInputText(processedArguments: List<String>): String {
        return when (processedArguments.size) {
            0 -> {
                writer.write("Enter text: ")
                // We need to flush in case the writer is buffered by lines, to make
                // sure the text is printed out to the user.
                writer.flush()

                textInputStream.bufferedReader().use { it.readLine() }
            }

            // First argument should be input filename
            1 -> {
                File(processedArguments.first()).readText()
            }

            else -> throw IllegalArgumentException("Expected at most 1 positional (non-flag) argument (path to file to count words from).")
        }
    }
}
