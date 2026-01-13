package reader

import java.io.File

class FileReader() {
    fun readFileByLine(filePath: String): List<String> {
        TODO("Implement checks and error handling as needed")
        return File(filePath).readLines()
    }
}