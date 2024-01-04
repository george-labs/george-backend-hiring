package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class IterationOneTaskTest {
    IterationOneTask iterationOneTask;

    @BeforeEach
    public void init() {
        iterationOneTask = new IterationOneTask();
    }

    @Test
    public void parseTestHappyPath() {
        iterationOneTask.userInput = "ONE TWO THREE";
        assertArrayEquals(new String [] {"ONE", "TWO", "THREE"}, iterationOneTask.parse());
    }

    @Test
    public void parseTestTrailingSpace() {
        iterationOneTask.userInput = "    ONE TWO THREE";
        assertArrayEquals(new String [] {"ONE", "TWO", "THREE"}, iterationOneTask.parse());
    }

    @Test
    public void parseTestNonAlpha() {
        iterationOneTask.userInput = "  ...  ONE TWO THREE";
        assertArrayEquals(new String [] {"ONE", "TWO", "THREE"}, iterationOneTask.parse());
    }

    @Test
    public void parseTestNonAlphaInWord() {
        iterationOneTask.userInput = "  ...  ONE...TWO THREE";
        assertArrayEquals(new String [] {"ONE", "TWO", "THREE"}, iterationOneTask.parse());
    }

    @Test
    public void testValidateMethod() {
        // due to missing dependencies I have to do it like this
        try {
            iterationOneTask.validate();
        } catch (IllegalStateException ex) {
            // TODO test message
            return;
        }
         fail();
    }
}