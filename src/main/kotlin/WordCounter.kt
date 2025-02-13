import abstract.StopWordsLoader

class WordCounter(private val fileLoader: StopWordsLoader) {

    // words are stretches of letters (a-z,A-Z)
    // not containing stopwords
    fun countWords(line: String): Int {
        if (line.isEmpty()) {
            return 0
        }
        val wordCounter = line.split("[\\s-]+".toRegex())
            .filter { isWord(it) }
            .count { !isStopword(it) }

        return wordCounter
    }


    fun isWord(word: String): Boolean {
        return word.matches("[a-zA-Z]+\\.?".toRegex())
    }

    // Stopwords are defined in the file stopwords.txt
    fun isStopword(word: String): Boolean {
        val stopWords = fileLoader.getStopWords()

        return stopWords.contains(word)
    }
}