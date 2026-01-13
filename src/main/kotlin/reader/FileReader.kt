package reader

import exception.FileReaderException
import java.io.File

class FileReader() {
    fun readFileByLine(filePath: String): List<String> {
        if (filePath.isBlank()) return emptyList<String>().also { println("stopword dictionary filepath is blank or empty. No stopwords will be in use") }
        val file = File(filePath)
        if (!file.exists()) return emptyList<String>().also { println("stopword dictionary file does not exist. No stopwords will be in use") }
        return runCatching { File(filePath).readLines() }.getOrElse {
            println("stopword dictionary file is not readable `${file.absolutePath}`")
            throw FileReaderException("Failed to read file at path: $filePath", it)
        }
    }
}