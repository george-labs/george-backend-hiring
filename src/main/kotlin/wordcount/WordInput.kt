package wordcount

import reader.InputReader
import java.io.File

/**
 * `WordInput` represents a user input, in particular:
 * - input: list of words either from a command line or a file
 * - the list of optional parameters, currently just `-index`
 */
class WordInput(
    val input: String?,
    val includeIndex: Boolean = false
) {

    companion object {

        const val OPTIONAL_INDEX_ARG = "-index"

        fun fromArguments(args: Array<String>, inputReader: InputReader): WordInput {
            val includeIndex: Boolean = args.any { it == OPTIONAL_INDEX_ARG }
            val input = fromFileOrCmd(args.firstOrNull { it != OPTIONAL_INDEX_ARG }, inputReader)
            return WordInput(input.input, includeIndex)
        }

        fun fromFileOrCmd(argument: String?, inputReader: InputReader): WordInput {
            if (argument != null) {
                return WordInput(fromFile(argument))
            }
            return WordInput(fromInput(inputReader))
        }

        private fun fromInput(inputReader: InputReader): String? {
            print("Enter text: ")
            val input = inputReader.readInput()
            return input
        }

        private fun fromFile(fileName: String): String? {
            val input = try {
                File(fileName)
                    .bufferedReader()
                    .use { reader ->
                        reader.readText()
                    }
            } catch (_: Exception) {
                println("File $fileName could not be read.")
                return null
            }

            return input
        }
    }
}