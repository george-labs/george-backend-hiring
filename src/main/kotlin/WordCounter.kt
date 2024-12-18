import inputReader.InputReader

class WordCounter(
    val stopWordLoader: StopWordLoader,
    private val inputReader: InputReader,
) {
    private val stopWords = stopWordLoader.loadFromResources()

    fun countWordsInText(): Int {
        val inputText = inputReader.read()
        return countWordsInText(inputText)
    }

    private fun countWordsInText(input: String): Int {
        val words = mutableListOf<String>()
        var currentWord = ""

        input.forEach { currentChar ->
            currentWord = if (currentChar.isWhitespace()) {
                if (currentWord.isNotEmpty())
                    words.add(currentWord)
                ""
            } else {
                currentWord.plus(currentChar)
            }
        }
        if (currentWord.isNotEmpty())
            words.add(currentWord)

        val validWords = words.filter { word -> word.none { !it.isLetter() } && !stopWords.contains(word) }
        return validWords.size
    }
}