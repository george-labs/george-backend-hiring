package com.dusanbartos.wordcount.domain

import com.dusanbartos.wordcount.data.Reader
import com.dusanbartos.wordcount.data.Writer

class WordCountApp(
    private val reader: Reader,
    private val writer: Writer,
    private val counter: WordCounter,
) {

    fun run() {
        writer.print("Enter text: ")
        val userInput = reader.read()
        val result = counter.countAll(sentence = userInput)
        writer.println("Number of words: $result")
    }
}