class WordCounter {

    fun countWords(text: String): Int {
        var wordCount = 0
        var isInsideWord = false

        for (i in text.indices) {
            val char = text[i]

            // Check if the character is a letter.
            if (char in 'a'..'z' || char in 'A'..'Z') {
                // Check if it's the start of a word.
                if (!isInsideWord && (i == 0 || !isLetter(text[i - 1]))) {
                    wordCount++
                }
                isInsideWord = true
            } else {
                isInsideWord = false
            }
        }

        return wordCount
    }

    // Helper function to determine if a character is a letter.
    fun isLetter(char: Char): Boolean {
        return char in 'a'..'z' || char in 'A'..'Z'
    }


    fun countWordsThis(text: String): Int {
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

    fun countWordsAbandon(text: String): Int {
        var wordCount = 0
        var isInsideWord = false
        var previousCharWasLetter = false

        for (char in text) {
            println("char: $char")
            if (isLetter(char)) {
                println("previousCharWasLetter: $char : $previousCharWasLetter")
                previousCharWasLetter = true
                if (!isInsideWord && previousCharWasLetter) {
                    wordCount++
                }
                isInsideWord = true
            } else {
                isInsideWord = false
            }
//            previousCharWasLetter = isLetter(char)
        }

        return wordCount
    }

    fun regexMatcher(char: Char): Boolean {
        // This method checks if the character is a non-letter.
        val nonLetterPattern = Regex("[^A-Za-z]")
        return nonLetterPattern.matches(char.toString())
    }

    // Optional: A helper method for clarity
    fun isLetterOld(char: Char): Boolean {
        return !regexMatcher(char)
    }

    fun countWordsIdiomatic(text: String): Int {
        return text.split(Regex("[^A-Za-z]+"))
            .filter { it.isNotBlank() }
            .count()
    }

    fun countWordsOld(text: String): Int {
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
