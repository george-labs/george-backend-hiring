package com.dusanbartos.wordcount.domain

import com.dusanbartos.wordcount.data.Reader
import com.dusanbartos.wordcount.data.StopWordReader
import com.dusanbartos.wordcount.data.Writer

class WordCountApp(
    private val reader: Reader,
    private val writer: Writer,
    private val counter: WordCounter,
    private val stopWordReader: StopWordReader,
) {

    fun run(config: WordCountAppConfig) {
        // manual input
        writer.print("Enter text: ")
        val userInput = reader.read()

        //TODO file input

        val result = counter.countAll(sentence = userInput, stopwords = stopWordReader.read("stopwords.txt"))
        writer.println("Number of words: $result")
    }
}