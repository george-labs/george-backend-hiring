package com.erste.interview.logic

class WordCounter {

    private val regex = Regex("[a-zA-Z]+")

    fun countWords(text: String): Int {
        return text.split(" ")
            .filter { regex.matches(it) }
            .size
    }

}