package at.erste.io

import java.io.File

class FileInputReader(val fileName: String) : InputReader {

    override fun readUserInput(prompt: String?): String {
        return File(fileName).readText()
    }
}
