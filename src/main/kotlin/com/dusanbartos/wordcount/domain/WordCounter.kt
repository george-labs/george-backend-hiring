package com.dusanbartos.wordcount.domain

import kotlin.math.pow

class WordCounter {

    companion object {
        private val WORD_REGEX = "[a-zA-Z]+".toRegex()
        private val SEPARATOR_REGEX = "\\s+".toRegex()
        private val PUNCTUATION_CHARS = charArrayOf(',', '.', '?', '!')
        // number of decimal places we want the result to be rounded to
        private const val AVERAGE_RESULT_PRECISION = 2
        private val ROUNDING_HELPER = 10.0.pow(AVERAGE_RESULT_PRECISION)
    }

    fun process(sentence: String, stopwords: Set<String> = emptySet()): WordCounterResult {
        val words = findWords(sentence, stopwords)

        return WordCounterResult(
            all = words.count(),
            unique = words.distinctBy { it.lowercase() }.count(),
            averageLength = words.map { it.length }.average().let {
                // trick to round to number of decimal places - (5.5555 * 100).toInt() / 100 -> 5.55
                (it * ROUNDING_HELPER).toInt().div(ROUNDING_HELPER)
            }
        )
    }

    private fun findWords(sentence: String, stopwords: Set<String>): Sequence<String> {
        val lowercaseStopwords = stopwords.map { it.lowercase() }.toSet()

        return sentence.split(SEPARATOR_REGEX)
            .asSequence()
            .map { it.trim(*PUNCTUATION_CHARS).replace("-", "") }
            .filter { WORD_REGEX.matches(it) }
            .filter { it.lowercase() !in lowercaseStopwords }
    }
}