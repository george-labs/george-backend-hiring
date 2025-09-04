package com.erste.interview.logic

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WordCounterTest {

    @Test
    fun `blank input`() {
        val counter = WordCounter()

        assertEquals(0, counter.count("", emptySet()).wordCount)
        assertEquals(0, counter.count(" ", emptySet()).wordCount)
    }

    @Test
    fun `special chars`() {
        val counter = WordCounter()

        assertEquals(0, counter.count("word3 word. wo-rd!", emptySet()).wordCount)
    }

    @Test
    fun `multiple words`() {
        val counter = WordCounter()

        assertEquals(1, counter.count("word", emptySet()).wordCount)
        assertEquals(2, counter.count("word word", emptySet()).wordCount)
    }

    @Test
    fun `stopwords are not counted`() {
        val counter = WordCounter()
        val stopWords = setOf("world", "to")

        val count = counter.count("hello world it is nice to be here", stopWords)
        assertEquals(6, count.wordCount)
    }

    @Test
    fun `empty stopwords`() {
        val counter = WordCounter()

        val count = counter.count("hello world it is nice to be here", emptySet())
        assertEquals(8, count.wordCount)
    }

    @Test
    fun `delimited by any whitespace`() {
        val counter = WordCounter()

        assertEquals(2, counter.count("word\tanotherword", emptySet()).wordCount)
        assertEquals(2, counter.count("word\nanotherword", emptySet()).wordCount)
    }

    @Test
    fun `count unique`() {
        val text = "a a b c a a a"
        val counter = WordCounter()

        assertEquals(3, counter.count(text, emptySet()).uniqueCount)
    }

    @Test
    fun `hypen char in words`() {
        val counter = WordCounter()

        assertEquals(CountResult(1, 1), counter.count("a-a", emptySet()))
        assertEquals(CountResult(1, 1), counter.count("a-----a", emptySet()))
        assertEquals(CountResult(1, 1), counter.count("a---b---a", emptySet()))
        assertEquals(CountResult(1, 1), counter.count("a-a-a", emptySet()))
        assertEquals(CountResult(1, 1), counter.count("a-a- b", emptySet()))
        assertEquals(CountResult(1, 1), counter.count("-a-a b", emptySet()))
        assertEquals(CountResult(0, 0), counter.count("-a", emptySet()))
        assertEquals(CountResult(0, 0), counter.count("a-", emptySet()))
        assertEquals(CountResult(0, 0), counter.count("-", emptySet()))
        assertEquals(CountResult(8, 6), counter.count("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", emptySet()))
    }


}