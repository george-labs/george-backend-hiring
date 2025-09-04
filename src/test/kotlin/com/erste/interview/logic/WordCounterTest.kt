package com.erste.interview.logic

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WordCounterTest {

    @Test
    fun `blank input`() {
        val counter = WordCounter()

        Assertions.assertEquals(0, counter.countWords(""))
        Assertions.assertEquals(0, counter.countWords(" "))
    }

    @Test
    fun `special chars`() {
        val counter = WordCounter()

        Assertions.assertEquals(0, counter.countWords("word3 word. wo-rd!"))
    }

    @Test
    fun `multiple words`() {
        val counter = WordCounter()

        Assertions.assertEquals(1, counter.countWords("word"))
        Assertions.assertEquals(2, counter.countWords("word word"))
    }

}