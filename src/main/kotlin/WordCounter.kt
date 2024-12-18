class WordCounter(val stopWords: Set<String>) {

    fun count(input: String): Int {
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