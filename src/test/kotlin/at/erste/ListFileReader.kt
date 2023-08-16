package at.erste

import at.erste.io.FileReader

class ListFileReader : FileReader {
    var lines: List<String>? = null

    override fun readByLine(fileName: String): List<String> {
        return lines ?: listOf()
    }
}
