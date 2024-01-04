package com.example.utils.predicates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsTrailingOrLeadingHyphenTest {
    IsTrailingOrLeadingHyphen isTrailingOrLeadingHyphen = new IsTrailingOrLeadingHyphen();

    @Test
    public void testLeadingHyphen() {
        assertTrue(isTrailingOrLeadingHyphen.test("-aaa"));
    }

    @Test
    public void testTrailingHyphen() {
        assertTrue(isTrailingOrLeadingHyphen.test("aaa-"));
    }

    @Test
    public void testNotLeadingOrTrailingHyphen() {
        assertFalse(isTrailingOrLeadingHyphen.test("aa-aa"));
    }

    @Test
    public void testIsJustHyphen() {
        assertTrue(isTrailingOrLeadingHyphen.test("-"));
    }
}