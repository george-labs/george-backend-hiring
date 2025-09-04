package com.erste.interview

import com.erste.interview.logic.WordCounter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.Reader
import java.io.Writer

fun main() {
    runWordCounter(InputStreamReader(System.`in`), OutputStreamWriter(System.out))
}

fun runWordCounter(input: Reader, output: Writer) {
    // 1. Output prompt to user
    output.write("Enter text: ")
    output.flush()

    // 2. Read input from user
    val input = input.readText()

    // 3. Call the business logic
    val wordCounter = WordCounter()
    val stopWords = readStopwords()
    val wordCount = wordCounter.countWords(input, stopWords)

    // 4. Output result to user
    output.write("\nNumber of words: $wordCount")
    output.flush()
}

private fun readStopwords(): Set<String> {
    val inputStream = object {}.javaClass.getResourceAsStream("/stopwords.txt") ?: throw RuntimeException("Resource stopwords.txt not available")
    return inputStream
        .bufferedReader()
        .readLines()
        .filter { it.isNotBlank() }
        .toSet()
}