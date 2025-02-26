package com.dusanbartos.wordcount.domain

class WordCounter {

    companion object {
        private val WORD_REGEX = "[a-zA-Z]+".toRegex()
        private val SEPARATOR_REGEX = "\\s+".toRegex()
    }

    fun countAll(sentence: String, stopwords: Set<String> = emptySet()): Int {
        val lowercaseStopwords = stopwords.map { it.lowercase() }.toSet()

        return sentence.split(SEPARATOR_REGEX)
            .asSequence()
            .filter { WORD_REGEX.matches(it) }
            .filter { it.lowercase() !in lowercaseStopwords }
            .count()
    }
}