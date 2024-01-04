package com.example.utils.predicates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsNotEmptyTest {

    @Test
    public void testIsNotEmpty() {
        IsNotEmpty isNotEmpty = new IsNotEmpty();
        assertTrue(isNotEmpty.test("OK"));
    }

    @Test
    public void testIsEmpty() {
        IsNotEmpty isNotEmpty = new IsNotEmpty();
        assertFalse(isNotEmpty.test(""));
    }

}