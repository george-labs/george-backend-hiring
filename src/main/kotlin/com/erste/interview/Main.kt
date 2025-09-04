package com.erste.interview

import com.erste.interview.logic.WordCounter

fun main() {
    print("Enter text: ")
    val input = readlnOrNull() ?: ""

    val wordCounter = WordCounter()
    val wordCount = wordCounter.countWords(input)

    println("Number of words: $wordCount")
}