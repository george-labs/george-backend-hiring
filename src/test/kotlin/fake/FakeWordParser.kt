package fake

import WordParser

class FakeWordParser : WordParser {
    override fun getWordsFromFile(path: String): List<String> {
        return listOf("test", "word")
    }
}