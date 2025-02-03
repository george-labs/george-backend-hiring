package util

import data.WordWrapper

class WordCounter {
    fun countWords(words: List<WordWrapper>) = filterWords(words).size

    fun countWords(words: List<WordWrapper>, stopWords: List<WordWrapper>) =
        filterWords(words = words, stopWords = stopWords).size

    fun countUniqueWords(words: List<WordWrapper>, stopWords: List<WordWrapper>): Int {
        val uniqueWords = mutableMapOf<String, Int>()
        words.map {
            var count = 0
            if (uniqueWords.contains(it.value)) {
                count = uniqueWords[it.value] ?: 0
                uniqueWords.replace(it.value, count.inc())
            } else {
                uniqueWords.put(it.value, count.inc())
            }
        }
        return words.count { word -> uniqueWords[word.value] == 1 && stopWords.none { word.value == it.value } && word.isAcceptedWord() }
    }

    fun averageWordLength(words: List<WordWrapper>): Float {
        var charCount = 0f
        words.map { word ->
            if (word.isAcceptedWord())
                charCount += word.value.length
        }
        return charCount.div(countWords(words).toFloat())
    }

    fun averageWordLength(words: List<WordWrapper>, stopWords: List<WordWrapper>): Float {
        var charCount = 0f
        words.map { word ->
            if (stopWords.none { word.value == it.value } && word.isAcceptedWord())
                charCount += word.value.length
        }
        return charCount.div(countWords(words, stopWords).toFloat())
    }


    fun filterWords(words: List<WordWrapper>) =
        words.filter { word -> word.isAcceptedWord() }

    fun filterWords(words: List<WordWrapper>, stopWords: List<WordWrapper>) =
        words.filter { word -> stopWords.none { word.value == it.value } && word.isAcceptedWord() }
}

fun String.splitToWords() =
    split(' ').map { WordWrapper(it) }