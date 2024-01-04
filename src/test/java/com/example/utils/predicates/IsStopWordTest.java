package com.example.utils.predicates;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IsStopWordTest {
    @Test
    public void testIsNotStopWord() {
        IsStopWord isStopWord = new IsStopWord(List.of("STOPA", "STOPB"));
        assertFalse(isStopWord.test("OK"));
    }

    @Test
    public void testIsStopWord() {
        IsStopWord isStopWord = new IsStopWord(List.of("STOPA", "STOPB"));
        assertTrue(isStopWord.test("STOPB"));
    }
}