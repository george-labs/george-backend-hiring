package wordcount

import reader.InputReader
import java.io.File

class WordInput(val input: String?) {

    companion object {

        fun fromFileOrCmd(argument: String?, inputReader: InputReader): WordInput {
            return argument?.let { fromFile(it) } ?: fromInput(inputReader)
        }

        fun fromInput(inputReader: InputReader): WordInput {
            print("Enter text: ")
            val input = inputReader.readInput()
            return WordInput(input)
        }

        fun fromFile(fileName: String): WordInput {
            val input = try {
                File(fileName)
                    .bufferedReader()
                    .use { reader ->
                        reader.readText()
                    }
            } catch (e: Exception) {
                println("File $fileName could not be read.")
                return WordInput(null)
            }

            return WordInput(input)
        }
    }
}