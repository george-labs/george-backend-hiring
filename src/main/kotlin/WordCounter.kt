class WordCounter {
    fun countWords(text: String): Int {
        val words = splitTextToWordsBySpace(text)
        val validWords = validateWordsWithRegex(words)

        return validWords.count()
    }

    private fun splitTextToWordsBySpace(text: String): List<String> {
        val cleanedText = text.replace(Regex("[,.]"), "")
        return cleanedText.split("\\s+".toRegex()).filter { it.isNotBlank() }
    }

    private fun validateWordsWithRegex(words: List<String>): List<String> {
        val regex = Regex("[^A-Za-z]")
        return words.filter { word -> regex.containsMatchIn(word).not() }
    }
}
