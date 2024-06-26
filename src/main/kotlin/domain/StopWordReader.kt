package domain

import data.FileReader

class StopWordReader(
    private val fileReader: FileReader,
) {

    fun getStopWords(fileName: String): Set<String> {
        val rawFileContent = fileReader.readFile("/$fileName")
        return rawFileContent.split("\n").filter { it.isNotEmpty() }.toSet()
    }


}