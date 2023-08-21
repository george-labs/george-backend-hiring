import java.io.File

class ReadFile(private var path: String): FileReader{
    override fun readLines(): List<String> {
        return File(this.path).bufferedReader().readLines()
    }
}