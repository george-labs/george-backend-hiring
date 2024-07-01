import java.io.FileNotFoundException

class ResourceTools {

    fun readTextFile(fileName: String): String {

        val resource = this::class.java.getResource(fileName)
        if(resource != null){
            return resource.readText(Charsets.UTF_8)
        } else {
            throw FileNotFoundException("Configuration file with stopwords was not found !");
        }
    }
}