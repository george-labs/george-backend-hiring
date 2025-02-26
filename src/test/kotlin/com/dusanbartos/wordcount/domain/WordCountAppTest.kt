package com.dusanbartos.wordcount.domain

import com.dusanbartos.wordcount.data.MockedReader
import com.dusanbartos.wordcount.data.MockedWriter
import com.dusanbartos.wordcount.data.ResourceFileReader
import com.dusanbartos.wordcount.data.ResourceStopWordReader
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WordCountAppTest {

    private lateinit var reader: MockedReader
    private lateinit var writer: MockedWriter
    private lateinit var app: WordCountApp

    @BeforeEach
    fun setup() {
        reader = MockedReader()
        writer = MockedWriter()
        app = WordCountApp(
            reader = reader,
            writer = writer,
            counter = WordCounter(),
            stopWordReader = ResourceStopWordReader(),
            inputFileReader = ResourceFileReader(),
        )
    }

    @Test
    fun `should correctly read user input and print output`() {
        // given
        reader.setup("Mary had a little lamb")

        // when
        app.run(config = WordCountAppConfig(inputFilePath = null))

        // then verify
        writer.assertEquals("Enter text: Number of words: 4, unique: 4; average word length: 4.25 characters")
    }

    @Test
    fun `should correctly read a given file input and print output`() {
        // given
        val config = WordCountAppConfig(inputFilePath = "test_input_1.txt")

        // when
        app.run(config = config)

        // then verify
        writer.assertEquals("Number of words: 4, unique: 4; average word length: 4.25 characters")
    }

    @Test
    fun `should not fail if the input file path is not existing`() {
        // given
        val config = WordCountAppConfig(inputFilePath = "test_input_2.txt")

        // when
        app.run(config = config)

        // then verify
        writer.assertEquals("Number of words: 0, unique: 0; average word length: 0.0 characters")
    }

    @Test
    fun `should correctly count unique words in a sentence and print output`() {
        // given
        reader.setup("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.")

        // when
        app.run(config = WordCountAppConfig(inputFilePath = null))

        // then verify
        writer.assertEquals("Enter text: Number of words: 7, unique: 6; average word length: 6.14 characters")
    }
}