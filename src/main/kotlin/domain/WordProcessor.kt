package domain

import data.ResourceFileReader

class WordProcessor {

    fun processWords(sentence: String) {
        val stopWordReader = StopWordReader(ResourceFileReader())
        val stopWords = stopWordReader.getStopWords("stopwords.txt")

        val countedWords = WordCounter().countAllWords(sentence, stopWords)
        val uniqueWords = WordCounter().countUniqueWords(sentence)
        println("Number of words: $countedWords, unique:$uniqueWords")
    }
}