package at.erste.io

class ListFileReader : FileReader {
    var lines: List<String>? = null

    override fun readByLine(fileName: String): List<String> {
        return lines ?: listOf()
    }
}
