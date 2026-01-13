package reader

import exception.FileReaderException
import java.io.File

class FileReader() {
    fun readFileByLine(filePath: String): List<String> {
        if (!isFileExists(filePath)) return emptyList()
        return runCatching { File(filePath).readLines() }.getOrElse {
            throwFileReaderExceptionAndPrintMessage(filePath, it)
        }
    }

    fun readFileToString(filePath: String): String {
        if (!isFileExists(filePath)) throw FileReaderException("File: $filePath is blank, empty or does not exist. It cannot be read.")
        return runCatching { File(filePath).readText() }.getOrElse {
            throwFileReaderExceptionAndPrintMessage(filePath, it)
        }
    }

    private fun throwFileReaderExceptionAndPrintMessage(filePath: String, throwable: Throwable): Nothing {
        println("$filePath file is not readable.")
        throw FileReaderException("Failed to read file at path: $filePath", throwable)
    }

    fun isFileExists(filePath: String): Boolean {
        if (filePath.isBlank()) return false.also { println("File: $filePath is blank or empty. No words from this file will be in use") }
        val file = File(filePath)
        if (!file.exists()) return false.also { println("File: $filePath does not exist. It will not be in use") }
        return true
    }
}