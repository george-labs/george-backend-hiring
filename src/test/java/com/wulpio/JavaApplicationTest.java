package com.wulpio;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {

    @ParameterizedTest
    @CsvSource({
            ",0,0",
            " ,0,0",
            "\n,0,0",
            "\\n,0,0",
            "test,1,1",
            "-HumptyDumpty sat on a wall.,1,1",
            "Humpty----Dumpty sat on a wall.,1,1",
            "HumptyDumpty- sat on a wall.,1,1",
            "Humpty-Dumpty- sat on a wall.,1,1",
            "-Humpty-Dumpty sat on a wall.,1,1",
            "dsa sad 1231@ 213 \",2,2"
    })
    void GIVEN_edge_case_sentence_from_parameter_WHEN_getCountOfWords_THEN_correct_number_of_words_and_unique_words_is_returned(String inputText,
                                                                                                                                int count,
                                                                                                                                int uniqueCount) {
        var javaApplication = new JavaApplication();

        WordCounterDto words = javaApplication.getWordMetrics(inputText);

        assertEquals(count, words.wordCount());
        assertEquals(uniqueCount, words.uniqueWordCount());
    }

    @ParameterizedTest
    @CsvSource({
            "Mary had a little lamb,4,4,4.25",
            "Mary! had a little lamb,3,3,4.333333333333333",
            "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.,5,4,7.4",
    })
    void GIVEN_sentence_from_parameter_WHEN_getCountOfWords_THEN_correct_number_of_words_is_returned(String inputText,
                                                                                                     int count,
                                                                                                     int uniqueCount,
                                                                                                     double averageWordLength) {
        var javaApplication = new JavaApplication();

        WordCounterDto words = javaApplication.getWordMetrics(inputText);

        assertEquals(count, words.wordCount());
        assertEquals(uniqueCount, words.uniqueWordCount());
        assertEquals(averageWordLength, words.averageWordLength());
    }

}
