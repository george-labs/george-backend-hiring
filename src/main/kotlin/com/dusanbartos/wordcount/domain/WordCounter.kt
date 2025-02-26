package com.dusanbartos.wordcount.domain

class WordCounter {

    companion object {
        private val WORD_REGEX = "[a-zA-Z]+".toRegex()
        private val SEPARATOR_REGEX = "[-\\s]+".toRegex()
        private val PUNCTUATION_CHARS = charArrayOf(',', '.', '?', '!')
    }

    fun countAll(sentence: String, stopwords: Set<String> = emptySet()): Int =
        findWords(sentence, stopwords)
            .count()

    fun countUnique(sentence: String, stopwords: Set<String> = emptySet()): Int =
        findWords(sentence, stopwords)
            .distinctBy { it.lowercase() }
            .count()

    private fun findWords(sentence: String, stopwords: Set<String>): Sequence<String> {
        val lowercaseStopwords = stopwords.map { it.lowercase() }.toSet()

        return sentence.split(SEPARATOR_REGEX)
            .asSequence()
            .also { println(it.toList()) }
            .map { it.trim(*PUNCTUATION_CHARS) }
            .also { println(it.toList()) }
            .filter { WORD_REGEX.matches(it) }
            .filter { it.lowercase() !in lowercaseStopwords }
    }
}