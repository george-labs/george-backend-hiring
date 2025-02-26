package com.dusanbartos.wordcount.domain

class WordCounter {

    companion object {
        private val WORD_REGEX = "[a-zA-Z]+".toRegex()
        private val SEPARATOR_REGEX = "[-\\s]+".toRegex()
        private val PUNCTUATION_CHARS = charArrayOf(',', '.', '?', '!')
    }

    fun process(sentence: String, stopwords: Set<String> = emptySet()): WordCounterResult =
        WordCounterResult(
            all = countAll(sentence, stopwords),
            unique = countUnique(sentence, stopwords),
        )

    private fun countAll(sentence: String, stopwords: Set<String>): Int =
        findWords(sentence, stopwords)
            .count()

    private fun countUnique(sentence: String, stopwords: Set<String>): Int =
        findWords(sentence, stopwords)
            .distinctBy { it.lowercase() }
            .count()

    private fun findWords(sentence: String, stopwords: Set<String>): Sequence<String> {
        val lowercaseStopwords = stopwords.map { it.lowercase() }.toSet()

        return sentence.split(SEPARATOR_REGEX)
            .asSequence()
            .map { it.trim(*PUNCTUATION_CHARS) }
            .filter { WORD_REGEX.matches(it) }
            .filter { it.lowercase() !in lowercaseStopwords }
    }
}