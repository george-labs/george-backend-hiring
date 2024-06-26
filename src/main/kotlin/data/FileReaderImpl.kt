package data

import java.nio.file.Path

class ResourceFileReader : FileReader {

    override fun readFile(fileName: String): String {
        return this::class.java.getResource(fileName)?.readText() ?: ""
    }

}

class PathFileReader : FileReader {

    override fun readFile(fileName: String): String {
        return Path.of(fileName).toFile().readText().replace("\n", " ")
    }


}

interface FileReader {
    fun readFile(fileName: String): String
}