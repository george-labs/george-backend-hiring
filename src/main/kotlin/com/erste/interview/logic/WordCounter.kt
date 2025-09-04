package com.erste.interview.logic

class WordCounter {

    private val regex = Regex("[a-zA-Z]+")

    fun countWords(text: String, stopWords: Set<String>): Int {
        return text.split(Regex("\\s+"))
            .filter { regex.matches(it) }
            .filterNot { stopWords.contains(it) }
            .size
    }

}