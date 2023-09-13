package sk.app.application.domain;

import org.junit.jupiter.api.Test;

import sk.app.application.ListWordReader;
import sk.app.application.port.incoming.WordCalculation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCalculationServiceTest {

	@Test
	public void testAverage() {
		WordCounterService wordCounterService = new WordCounterService(new WordFilterService(new ListWordReader()));

		WordCalculation wordCalculation = new WordCalculationService(wordCounterService);

		assertEquals(5.0d, wordCalculation.calculateAverageWordLength("aa aaaaaaaa"));
		assertEquals(2.0d, wordCalculation.calculateAverageWordLength("aa"));

	}
}
