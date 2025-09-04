package com.erste.interview.logic

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WordCounterTest {

    @Test
    fun `blank input`() {
        val counter = WordCounter()

        Assertions.assertEquals(0, counter.countWords("", emptySet()))
        Assertions.assertEquals(0, counter.countWords(" ", emptySet()))
    }

    @Test
    fun `special chars`() {
        val counter = WordCounter()

        Assertions.assertEquals(0, counter.countWords("word3 word. wo-rd!", emptySet()))
    }

    @Test
    fun `multiple words`() {
        val counter = WordCounter()

        Assertions.assertEquals(1, counter.countWords("word", emptySet()))
        Assertions.assertEquals(2, counter.countWords("word word", emptySet()))
    }

    @Test
    fun `stopwords are not counted`() {
        val counter = WordCounter()
        val stopWords = setOf("world", "to")

        val count = counter.countWords("hello world it is nice to be here", stopWords)
        Assertions.assertEquals(6, count)
    }

    @Test
    fun `empty stopwords`() {
        val counter = WordCounter()

        val count = counter.countWords("hello world it is nice to be here", emptySet())
        Assertions.assertEquals(8, count)
    }

    @Test
    fun `delimited by any whitespace`() {
        val counter = WordCounter()

        Assertions.assertEquals(2, counter.countWords("word\tanotherword", emptySet()))
        Assertions.assertEquals(2, counter.countWords("word\nanotherword", emptySet()))
    }

}