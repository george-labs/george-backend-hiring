package at.erste.digital.wordcounter

import at.erste.digital.wordcounter.service.InputStatisticsService
import at.erste.digital.wordcounter.service.InputTextStatistics
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigDecimal

class InputStatisticsServiceTest {

    @DisplayName("Word count with no stop words")
    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class NoStopWordsTests {
        private fun inputStatisticsTestWithoutStopWordsArguments() = listOf(
            Arguments.of("", InputTextStatistics(0, 0, BigDecimal.valueOf(0, 2))),
            Arguments.of("         ", InputTextStatistics(0, 0, BigDecimal.valueOf(0, 2))),
            Arguments.of("test", InputTextStatistics(1, 1, "4.00".toBigDecimal())),
            Arguments.of("   test ", InputTextStatistics(1, 1, "4.00".toBigDecimal())),
            Arguments.of("test word", InputTextStatistics(2, 2, "4.00".toBigDecimal())),
            Arguments.of("   test 123 ana wien atttt ", InputTextStatistics(4, 4, "4.00".toBigDecimal())),
            Arguments.of("   123a 123,,, ana, wien123 atttt1 ", InputTextStatistics(0, 0, "0.00".toBigDecimal())),
            Arguments.of(
                """
            ana has a nice dog
            the dog is a border collie
        """.trimIndent(), InputTextStatistics(11, 9, "3.18".toBigDecimal())
            ),
            Arguments.of("test 123 test ana dog ana test", InputTextStatistics(6, 3, "3.50".toBigDecimal())),
            Arguments.of("123 123 ana ana", InputTextStatistics(2, 1, "3.00".toBigDecimal())),
            Arguments.of("bielsko-biala ana bielsko-biala ana", InputTextStatistics(4, 2, "8.00".toBigDecimal())),
        )


        @ParameterizedTest(name = "should return {1} when input is {0}")
        @MethodSource("inputStatisticsTestWithoutStopWordsArguments")
        fun `should return correct input statistics`(input: String, expectedStatistics: InputTextStatistics) {
            //GIVEN
            val inputStatisticsService = InputStatisticsService()
            //WHEN
            val numberOfWords = inputStatisticsService.getInputStatistics(input)
            //THEN
            assertEquals(expectedStatistics, numberOfWords)
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
        """.trimIndent(), InputTextStatistics(
                    8, 7, "3.75".toBigDecimal()
                )
            ),
            Arguments.of(
                listOf(" ", "   "), """
            ana has a nice dog
            the dog is a border collie
        """.trimIndent(), InputTextStatistics(
                    11, 9, "3.18".toBigDecimal()
                )
            ),
            Arguments.of(
                listOf("ana"), "bielsko-biala ana bielsko-biala ana", InputTextStatistics(2, 1, "13.00".toBigDecimal()),
            )
        )

        @ParameterizedTest(name = "should return {2} when input is {1} and stop words are {0}")
        @MethodSource("wordCountTestWithStopWordsArguments")
        fun `should return correct word count`(
            stopWords: List<String>,
            input: String,
            expectedStatistics: InputTextStatistics
        ) {
            //GIVEN
            val inputStatisticsService = InputStatisticsService(stopWords)

            //WHEN
            val numberOfWords = inputStatisticsService.getInputStatistics(input)
            //THEN
            assertEquals(expectedStatistics, numberOfWords)
        }
    }
}