package InputReader

import java.io.FileNotFoundException

class TextFileReader(private val fileName: String): InputInterface {

    override
    fun readText(): String {
        val resource = this::class.java.getResource(fileName)
        if(resource != null){
            return resource.readText(Charsets.UTF_8)
        } else {
            throw FileNotFoundException("File $fileName not found !");
        }
    }
}