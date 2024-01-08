package fake

import FileWordParser

class FakeFileWordParser : FileWordParser {
    override fun getWordsFromFile(path: String): List<String> {
        return listOf("test", "word")
    }
}