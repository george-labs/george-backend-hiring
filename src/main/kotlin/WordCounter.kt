class WordCounter(fileLoader: FileLoader) {

    val stopWords = fileLoader.stopWords

    // Words are stretches of letters (a-z,A-Z)
    fun countWords(line: String): Int {
        if (line.isEmpty()) {
            return 0
        }
        val wordCounter = line.split("\\s+".toRegex()).count { isWord(it) }

        return wordCounter
    }


    fun isWord(word: String): Boolean {
        return word.matches("[a-zA-Z]+".toRegex())
    }

    fun isStopword(word: String): Boolean {
        return stopWords.contains(word)
    }
}