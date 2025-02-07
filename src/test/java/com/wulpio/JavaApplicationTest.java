package com.wulpio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {

    @ParameterizedTest
    @CsvSource({
            ",0",
            " ,0",
            "\n,0",
            "\\n,0",
            "test,1",
            "Mary had a little lamb,5",
            "Mary! had a little lamb,4",
            "dsa sad 1231@ 213 \",2"
    })
    void GIVEN_sentence_from_parameter_WHEN_getCountOfWords_THEN_correct_number_of_words_is_returned(String inputText, int count) {
        var javaApplication = new JavaApplication();

        int countOfWords = javaApplication.getCountOfWords(inputText);

        assertEquals(count, countOfWords);
    }

    @Test
    void smokeTest() {
        var javaApplication = new JavaApplication();

        javaApplication.provideInput("Baeldung");

        javaApplication.readLineAndCountWords();
    }

}
