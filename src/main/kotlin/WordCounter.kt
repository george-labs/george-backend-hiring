class WordCounter(fileReader: IFileReader) {
    private val stopWords by lazy { fileReader.readLines().toSet() }

    private var validWords = listOf<String>()

    fun countWords(text: String): Int {
        val words = splitTextToWordsBySpace(text)
        validWords = validateWordsWithRegex(words)
        this.validWords = validWords.filterNot { it in stopWords }

        return validWords.count()
    }

    fun countUniqueWords(): Int {
        return validWords.toSet().count()
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
