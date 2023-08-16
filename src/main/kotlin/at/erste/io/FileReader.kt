package at.erste.io

interface FileReader {
    fun readByLine(fileName: String): List<String>
}
