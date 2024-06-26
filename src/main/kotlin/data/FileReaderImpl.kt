package data

class ResourceFileReader : FileReader {

    override fun readFile(fileName: String): String {
        return this::class.java.getResource(fileName)?.readText() ?: ""
    }

}

interface FileReader {
    fun readFile(fileName: String): String
}