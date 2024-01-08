import java.io.File

class LineByLineWordParser : WordParser {

    override fun getWordsFromFile(path: String): List<String> {
        return File(path).readLines()
    }
}