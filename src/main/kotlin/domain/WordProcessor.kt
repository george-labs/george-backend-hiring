package domain

import data.ResourceFileReader

class WordProcessor {

    fun processWords(sentence: String) {
        val stopWordReader = StopWordReader(ResourceFileReader())
        val stopWords = stopWordReader.getStopWords("stopwords.txt")

        val countedWords = WordCounter().count(sentence, stopWords)
        println("Number of words: $countedWords")
    }
}