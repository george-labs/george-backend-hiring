package com.dusanbartos.wordcount.domain

import com.dusanbartos.wordcount.data.FileReader
import com.dusanbartos.wordcount.data.Reader
import com.dusanbartos.wordcount.data.StopWordReader
import com.dusanbartos.wordcount.data.Writer

class WordCountApp(
    private val reader: Reader,
    private val writer: Writer,
    private val counter: WordCounter,
    private val stopWordReader: StopWordReader,
    private val inputFileReader: FileReader,
) {

    fun run(config: WordCountAppConfig) {

        val sentence = if (config.inputFilePath != null) {
            // input provided in a file
            inputFileReader.read(config.inputFilePath)
        } else {
            // manual input
            writer.print("Enter text: ")
            reader.read()
        }

        val result = counter.process(
            sentence = sentence,
            stopwords = stopWordReader.read("stopwords.txt")
        )
        writer.println("Number of words: ${result.all}, unique: ${result.unique}")
    }
}