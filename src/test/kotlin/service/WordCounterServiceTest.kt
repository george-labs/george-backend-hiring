package service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class WordCounterServiceTest {
    private val wordCounterService = WordCounterService()

    @ParameterizedTest
    @MethodSource("countWordsSource")
    fun `wordCounter should calculate words correctly`(line: String, expectedWordCount: Int) {
        val actual = wordCounterService.countWords(line)
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
    }
}