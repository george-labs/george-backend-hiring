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
            "Mary had a little lamb,4,4",
            "Mary! had a little lamb,3,3",
            "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.,7,5",
            "dsa sad 1231@ 213 \",2,2"
    })
    void GIVEN_sentence_from_parameter_WHEN_getCountOfWords_THEN_correct_number_of_words_is_returned(String inputText, int count, int uniqueCount) {
        var javaApplication = new JavaApplication();

        WordCounterDto words = javaApplication.getCountOfWords(inputText);

        assertEquals(count, words.wordCount());
        assertEquals(uniqueCount, words.uniqueWordCount());
    }

}
