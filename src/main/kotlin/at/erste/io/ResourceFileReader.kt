package at.erste.io

/**
 * generic filesystem file reader, other methods to be added
 */
class ResourceFileReader : FileReader {

    /**
     * Reads a file and returns a list of lines
     * @param fileName the name of the file to read
     * @return a list of unique words or an empty list if the file is not found
     */
    override fun readByLine(fileName: String): List<String> {
        val content = this.javaClass.getResource(fileName)?.readText()
        val lines = mutableListOf<String>()
        content?.split("\n")?.forEach {
            lines.add(it.replace("\r", ""))
        }
        return lines
    }
}
