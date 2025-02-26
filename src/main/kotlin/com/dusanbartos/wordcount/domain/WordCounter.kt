package com.dusanbartos.wordcount.domain

class WordCounter {

    companion object {
        private val WORD_REGEX = "[a-zA-Z]+".toRegex()
        private val SEPARATOR_REGEX = "\\s+".toRegex()
    }

    fun countAll(sentence: String): Int =
        sentence.split(SEPARATOR_REGEX)
            .asSequence()
            .filter { WORD_REGEX.matches(it) }
            .count()
}