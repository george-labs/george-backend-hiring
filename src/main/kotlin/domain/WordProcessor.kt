package domain

import data.ResourceFileReader

class WordProcessor(
    private val wordCounter: WordCounter,
    private val stopWordReader: StopWordReader,
) {

    fun processWords(sentence: String) {
        val stopWords = stopWordReader.getStopWords("stopwords.txt")

        val countedWords = wordCounter.countAllWords(sentence, stopWords)
        val uniqueWords = wordCounter.countUniqueWords(sentence, stopWords)
        val averageWordLength = wordCounter.averageWordLength(sentence, stopWords)

        println("Number of words: $countedWords, unique: $uniqueWords, average word length: $averageWordLength")
    }
}