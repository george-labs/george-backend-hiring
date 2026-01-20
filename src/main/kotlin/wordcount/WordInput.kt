package wordcount

import reader.InputReader
import java.io.File

class WordInput(
    val input: String?,
    val includeIndex: Boolean = false
) {

    companion object {

        fun fromArguments(args: Array<String>, inputReader: InputReader): WordInput {
            val includeIndex: Boolean = args.any { it == "-index" }
            val inputFile = args.filter { !it.startsWith("-") }.firstOrNull()

            val input = inputFile?.let { fromFile(it) } ?: fromInput(inputReader)

            return WordInput(input, includeIndex)
        }

        fun fromFileOrCmd(argument: String?, inputReader: InputReader): WordInput {
            val input = argument?.let { fromFile(it) } ?: fromInput(inputReader)
            return WordInput(input)
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