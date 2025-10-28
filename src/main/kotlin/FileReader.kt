import java.io.File

interface FileReader {
    fun readFile(filePath: String): String {
        return File(filePath).readText()
    }
}

class FileReaderImpl : FileReader {
}

class StopWordsReader: FileReader {
    fun getStopWordsAsSet(filePath: String): Set<String> {
        val input = readFile(filePath)
        return input.split("\n").map { it.trim() }.toSet()
    }
}