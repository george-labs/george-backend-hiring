package wordcount

import java.io.File

class WordInput(val input: String) {

    companion object {

        fun fromFileOrCmd(argument: String?): WordInput {
            return argument?.let { fromFile(it) } ?: fromInput()
        }

        fun fromInput(): WordInput {
            println("Enter text:")
            val input = readlnOrNull() ?: throw Exception("Input can't be empty")
            return WordInput(input)
        }

        fun fromFile(fileName: String): WordInput {
            val input = File(fileName)
                .bufferedReader()
                .use { reader ->
                    reader.readText()
                } ?: throw Exception("File does not exist ")

            return WordInput(input)
        }
    }
}