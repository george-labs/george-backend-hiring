package com.erste.mm.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WordServiceTest {

    private final String TEST_NON_SPECIAL_WORD = "testTest";
    private final String TEST_SPECIAL_WORD = "testTest1";

    @Test
    void testWordServiceCanFilterOutSpecialCharacterWords() {
        long count = WordService.countWords(TEST_NON_SPECIAL_WORD + " " + TEST_SPECIAL_WORD);

        Assertions.assertEquals(1, count);
    }
}
