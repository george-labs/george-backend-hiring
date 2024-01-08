import java.io.File

class LineByLineFileWordParser : FileWordParser {

    override fun getWordsFromFile(path: String): List<String> {
        return File(path).readLines()
    }
}