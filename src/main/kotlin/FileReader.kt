import extensions.getDividedWords

class FileReader {
    private val stopWordFileName = "stopwords.txt"
    private val dictionaryFileName = "dict.txt"

    fun readStopWords(): List<String>? {
        return readFromFile(stopWordFileName)
    }

    fun readWords(fileName: String?): List<String>? {
        return readFromFile(fileName)
    }

    fun readDictionary(): List<String>? {
        return readFromFile(dictionaryFileName)
    }

    private fun readFromFile(fileName: String?): List<String>? {
        val file = fileName?.let { getResourceAsText(fileName) }
        return file?.lines()?.flatMap { it.getDividedWords() }
    }

    private fun getResourceAsText(path: String): String? =
        object {}.javaClass.getResource(path)?.readText()
}