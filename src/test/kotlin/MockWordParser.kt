class MockWordParser : WordParser {
    override fun getWordsFromFile(path: String): List<String> {
        return listOf("test", "word")
    }
}