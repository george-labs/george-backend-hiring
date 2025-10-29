package at.erste.digital.wordcounter

import at.erste.digital.wordcounter.service.WordCounter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WordCounterTest {

    @DisplayName("Word count with no stop words")
    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class NoStopWordsTests {
        private fun wordCountTestWithoutStopWordsArguments() = listOf(
            Arguments.of("", 0),
            Arguments.of("         ", 0),
            Arguments.of("test", 1),
            Arguments.of("   test ", 1),
            Arguments.of("test word", 2),
            Arguments.of("   test 123 ana wien atttt ", 4),
            Arguments.of("   123a 123,,, ana, wien123 atttt1 ", 0),
            Arguments.of(
                """
            ana has a nice dog
            the dog is a border collie
        """.trimIndent(), 11
            ),
            Arguments.of("bielsko-biala ana bielsko-biala ana", 4),
        )

        private fun uniqueWordCountTestWithoutStopWordsArguments() = listOf(
            Arguments.of("", 0),
            Arguments.of("         ", 0),
            Arguments.of("test", 1),
            Arguments.of("   123a 123,,, ana, wien123 atttt1 ", 0),
            Arguments.of(
                """
            ana has a nice dog
            the dog is a border collie
        """.trimIndent(), 9
            ),
            Arguments.of("test 123 test ana dog ana test", 3),
            Arguments.of("123 123 ana ana", 1),
            Arguments.of("bielsko-biala ana bielsko-biala ana", 2),
        )

        @ParameterizedTest(name = "should return {1} when input is {0}")
        @MethodSource("wordCountTestWithoutStopWordsArguments")
        fun `should return correct word count`(input: String, expectedCount: Int) {
            //GIVEN
            val wordCounter = WordCounter()
            //WHEN
            val numberOfWords = wordCounter.countWords(input)
            //THEN
            assertEquals(expectedCount, numberOfWords)
        }

        @ParameterizedTest(name = "should return {1} when input is {0}")
        @MethodSource("uniqueWordCountTestWithoutStopWordsArguments")
        fun `should return correct unique word count`(input: String, expectedCount: Int) {
            //GIVEN
            val wordCounter = WordCounter()
            //WHEN
            val numberOfWords = wordCounter.countUniqueWords(input)
            //THEN
            assertEquals(expectedCount, numberOfWords)
        }
    }

    @DisplayName("Word count with stop words")
    @TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
    @Nested
    inner class StopWordsTests {
        private fun wordCountTestWithStopWordsArguments() = listOf(
            Arguments.of(
                listOf("a", "the"), """
            ana has a nice dog
            the dog is a border collie
        """.trimIndent(), 8
            ),
            Arguments.of(
                listOf(" ", "   "), """
            ana has a nice dog
            the dog is a border collie
        """.trimIndent(), 11
            ),
            Arguments.of(listOf("ana"), "bielsko-biala ana bielsko-biala ana", 2),
        )

        private fun uniqueWordCountTestWithStopWordsArguments() = listOf(
            Arguments.of(
                listOf("a", "the"), """
            ana has a nice dog
            the dog is a border collie
        """.trimIndent(), 7
            ),
            Arguments.of(
                listOf(" ", "   "), """
            ana has a nice dog
            the dog is a border collie
        """.trimIndent(), 9
            ),
            Arguments.of(listOf("ana"), "bielsko-biala ana a bielsko-biala ana a", 2),
        )

        @ParameterizedTest(name = "should return {2} when input is {1} and stop words are {0}")
        @MethodSource("wordCountTestWithStopWordsArguments")
        fun `should return correct word count`(stopWords: List<String>, input: String, expectedCount: Int) {
            //GIVEN
            val wordCounter = WordCounter(stopWords)

            //WHEN
            val numberOfWords = wordCounter.countWords(input)
            //THEN
            assertEquals(expectedCount, numberOfWords)
        }

        @ParameterizedTest(name = "should return {2} when input is {1} and stop words are {0}")
        @MethodSource("uniqueWordCountTestWithStopWordsArguments")
        fun `should return correct unique word count`(stopWords: List<String>, input: String, expectedCount: Int) {
            //GIVEN
            val wordCounter = WordCounter(stopWords)

            //WHEN
            val numberOfWords = wordCounter.countUniqueWords(input)
            //THEN
            assertEquals(expectedCount, numberOfWords)
        }
    }
}