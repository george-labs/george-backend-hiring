class WordCounter {
    fun countWordsIdiomatic(text: String): Int {
        return text.split(Regex("[^A-Za-z]+"))
            .filter { it.isNotBlank() }
            .count()
    }

    fun countWords(text: String): Int {
        var wordCount = 0
        var isInsideWord = false

        for (char in text) {
            if (char in 'a'..'z' || char in 'A'..'Z') {
                if (!isInsideWord) {
                    // Transition from non-letter to letter indicates a new word.
                    wordCount++
                    isInsideWord = true
                }
            } else {
                // Transition from letter to non-letter.
                isInsideWord = false
            }
        }

        return wordCount
    }

}
