package service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

typealias InputString = String
typealias StopWordsStringList = List<String>

class WordCounterServiceTest {
    val wordCounterService = WordCounterService()

    @ParameterizedTest
    @MethodSource("countWordsSource")
    fun `wordCounter should calculate words correctly`(inputLine: String, expectedWordCount: Int) {
        val actual = wordCounterService.countWords(inputLine).totalWords
        assertEquals(expectedWordCount, actual)
    }

    @ParameterizedTest
    @MethodSource("countWordsWithStopWordsExamples")
    fun `wordCounter should calculate words correctly`(
        input: Pair<InputString, StopWordsStringList>,
        expectedWordCount: Int
    ) {
        val (inputLine, stopWords) = input
        val wordCounterService = WordCounterService(stopWords = stopWords)
        val actual = wordCounterService.countWords(inputLine).totalWords
        assertEquals(expectedWordCount, actual)
    }

    @ParameterizedTest
    @MethodSource("countWordsWithUniqueWordsSource")
    fun `wordCounter should calculate unique words correctly`(
        input: InputString,
        stopWords: StopWordsStringList,
        expectedWordCount: Int
    ) {
        val wordCounterService = WordCounterService(stopWords = stopWords)
        val actual = wordCounterService.countWords(input).uniqueWords
        assertEquals(expectedWordCount, actual)
    }

    companion object {
        @JvmStatic
        fun countWordsSource(): Stream<Arguments> = mapOf(
            "Mary had a little lamb" to 5,
            "Hello world" to 2,
            " Hello world " to 2,
            "Kotlin is great!" to 3,
            "JUnit 5 testing" to 2,
            "" to 0,
            "One" to 1,
            "word" to 1,
            "word word" to 2,
            "word word2d" to 3,
            "123 456" to 0,
            "Special_characters!@#" to 2,
            "Mix3d content with numb3rs and lett3rs" to 9,
            "Word,,, , with punctuation." to 3,
        ).entries.stream().map { Arguments.of(it.key, it.value) }

        @JvmStatic
        fun countWordsWithStopWordsExamples(): Stream<Arguments> = mapOf<Pair<InputString, StopWordsStringList>, Int>(
            Pair("Mary had a little lamb", listOf("the", "a", "on", "off")) to 4,
            Pair("Mary had no little lamb", listOf("the", "a", "on", "off")) to 5,
            Pair("Hello world", listOf("hello")) to 2,
            Pair("hello world", listOf("hello")) to 1,
            Pair("", listOf("word")) to 0,
            Pair("word", listOf("word")) to 0,
            Pair("word word", listOf("word")) to 0,
            Pair("word word2d", emptyList<String>()) to 3,
        ).entries.stream().map { Arguments.of(it.key, it.value) }

        @JvmStatic
        fun countWordsWithUniqueWordsSource(): Stream<Arguments> = listOf(
            Triple("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", listOf("the", "a", "on", "off"), 7),
            Triple("Hello hello world", emptyList(), 3),
            Triple("hello hello world", emptyList(), 2),
            Triple("word word word", emptyList(), 1),
            Triple("", emptyList(), 0),
            Triple("One", emptyList(), 1),
            Triple("Hello word", emptyList(), 2),
        ).stream().map { Arguments.of(it.first, it.second, it.third) }
    }
}