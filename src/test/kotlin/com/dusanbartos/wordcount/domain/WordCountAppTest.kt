package com.dusanbartos.wordcount.domain

import com.dusanbartos.wordcount.data.MockedReader
import com.dusanbartos.wordcount.data.MockedWriter
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
            counter = WordCounter()
        )
    }

    @Test
    fun `should correctly read user input and print output`() {
        // given
        reader.setup("Mary had a little lamb")

        // when
        app.run()

        // then verify
        writer.assertEquals("Enter text: Number of words: 5")
    }
}