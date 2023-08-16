package at.erste

class FileReader {

    /**
     * Reads a file and returns a list of lines
     * @param fileName the name of the file to read
     * @return a list of unique words or an empty list if the file is not found
     */
    fun readByLine(fileName: String = "/stopwords.txt"): List<String> {
        val content = this.javaClass.getResource(fileName)?.readText()
        val skippedWords = mutableListOf<String>()
        content?.split("\n")?.forEach {
            skippedWords.add(it.replace("\r", ""))
        }
        return skippedWords
    }
}
