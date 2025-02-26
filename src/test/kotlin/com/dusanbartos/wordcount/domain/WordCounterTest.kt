package com.dusanbartos.wordcount.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WordCounterTest {

    private lateinit var counter: WordCounter

    @BeforeEach
    fun setup() {
        counter = WordCounter()
    }

    @ParameterizedTest
    @CsvSource(
        "Mary had a little lamb; 5",
        "Mary had a little; 4",
        "Lorem ipsum dolor sit amet; 5",
        "Lorem; 1",
        "Loooooooooooooorem iiiiipppppsssssssssssssuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuum; 2",
        delimiter = ';'
    )
    fun `only valid alphabetical characters in words`(sentence: String, expected: Int) {
        val result = counter.countAll(sentence)
        Assertions.assertEquals(expected, result) { "Unexpected word count" }
    }

    @ParameterizedTest
    @CsvSource(
        "Mary had a l1ttle lamb; 4",
        "Mary had, a little!; 2",
        "Lo_rem ip*sum dolor, si't amet.; 0",
        delimiter = ';'
    )
    fun `invalid characters in words`(sentence: String, expected: Int) {
        val result = counter.countAll(sentence)
        Assertions.assertEquals(expected, result) { "Unexpected word count" }
    }

    @ParameterizedTest
    @CsvSource(
        "'   Mary'; 1",
        "' a  b .../ c.  ,'; 2",
        "' '; 0",
        "'         '; 0",
        delimiter = ';'
    )
    fun `invalid input`(sentence: String, expected: Int) {
        val result = counter.countAll(sentence)
        Assertions.assertEquals(expected, result) { "Unexpected word count" }
    }

    @ParameterizedTest
    @CsvSource(
        "Mary had a little lamb; 3",
        "Mary had a little; 2",
        "Lorem ipsum dolor sit amet; 5",
        "The had had a on a hat; 1",
        delimiter = ';'
    )
    fun `stopwords are filtered out`(sentence: String, expected: Int) {
        val stopwords = setOf("had", "a", "the", "on")

        val result = counter.countAll(sentence, stopwords)
        Assertions.assertEquals(expected, result) { "Unexpected word count" }
    }
}