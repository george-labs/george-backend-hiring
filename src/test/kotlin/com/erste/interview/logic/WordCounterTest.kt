package com.erste.interview.logic

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WordCounterTest {

    @Test
    fun `blank input`() {
        val counter = WordCounter()

        Assertions.assertEquals(0, counter.count("", emptySet()).wordCount)
        Assertions.assertEquals(0, counter.count(" ", emptySet()).wordCount)
    }

    @Test
    fun `special chars`() {
        val counter = WordCounter()

        Assertions.assertEquals(0, counter.count("word3 word. wo-rd!", emptySet()).wordCount)
    }

    @Test
    fun `multiple words`() {
        val counter = WordCounter()

        Assertions.assertEquals(1, counter.count("word", emptySet()).wordCount)
        Assertions.assertEquals(2, counter.count("word word", emptySet()).wordCount)
    }

    @Test
    fun `stopwords are not counted`() {
        val counter = WordCounter()
        val stopWords = setOf("world", "to")

        val count = counter.count("hello world it is nice to be here", stopWords)
        Assertions.assertEquals(6, count.wordCount)
    }

    @Test
    fun `empty stopwords`() {
        val counter = WordCounter()

        val count = counter.count("hello world it is nice to be here", emptySet())
        Assertions.assertEquals(8, count.wordCount)
    }

    @Test
    fun `delimited by any whitespace`() {
        val counter = WordCounter()

        Assertions.assertEquals(2, counter.count("word\tanotherword", emptySet()).wordCount)
        Assertions.assertEquals(2, counter.count("word\nanotherword", emptySet()).wordCount)
    }

    @Test
    fun `count unique`() {
        val text = "a a b c a a a"
        val counter = WordCounter()

        Assertions.assertEquals(3, counter.count(text, emptySet()).uniqueCount)
    }

}