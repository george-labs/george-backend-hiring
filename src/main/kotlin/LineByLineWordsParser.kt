import java.io.File

class LineByLineWordsParser : WordsParser {

    override fun getWordsFromFile(path: String): List<String> {
        return File(path).readLines()
    }
}