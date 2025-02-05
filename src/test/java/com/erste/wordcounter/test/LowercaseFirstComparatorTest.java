package com.erste.wordcounter.test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.erste.wordcounter.LowercaseFirstComparator;

public class LowercaseFirstComparatorTest {

	@Test
	public void testWhenEqualStringsThen0() {
		assertTrue(new LowercaseFirstComparator().compare("Hello", "Hello") == 0);
	}

	@Test
	public void testWhenLowercaseAndUppercaseStringsThenMinus1() {
		assertTrue(new LowercaseFirstComparator().compare("hello", "HELLO") == -1);
	}

	@Test
	public void testWhenUppercaseAndLowercaseStringsThen1() {
		assertTrue(new LowercaseFirstComparator().compare("HELLO", "hello") == 1);
	}

	@Test
	public void testWhenTheSameCaseStringsThenNaturalOrderingIsUsed() {
		assertTrue(new LowercaseFirstComparator().compare("abc", "bbc") == -1);
	}
}