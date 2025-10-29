package at.erste.digital.wordcounter.input

import java.nio.file.Files
import java.nio.file.Paths

interface UserInputReader {
    fun readWords(): Result<String>
}

class StandardInputReader() : UserInputReader {
    override fun readWords(): Result<String> {
        return runCatching {
            println("Enter text: ")
            readln()
        }
    }

}

class FileInputReader(private val fileName: String) : UserInputReader {
    override fun readWords(): Result<String> {
        return runCatching { Files.readString(Paths.get(fileName)) }
    }

}