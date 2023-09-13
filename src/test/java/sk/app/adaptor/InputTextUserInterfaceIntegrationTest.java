package sk.app.adaptor;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import sk.app.adaptor.ui.InputTextUserInterface;
import sk.app.adaptor.ui.UserInterface;
import sk.app.application.port.incoming.WordCalculation;
import sk.app.application.port.incoming.WordCounter;
import sk.app.application.port.outgoing.InputTextReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTextUserInterfaceIntegrationTest {

	@Test
	public void testInputTextUserInterfaceIntegrationTest() throws IOException {

		MockedWordCounter mockedWordCounter = new MockedWordCounter();
		MockedWordCounter mockedUniqueWordCounter = new MockedWordCounter();
		WordCalculation mockedWordCalculation = new MockedWordCalculation();

		UserInterface userInterface = new InputTextUserInterface(mockedWordCounter, mockedUniqueWordCounter,
				mockedWordCalculation, new MockedReader("some text"));
		userInterface.countWords();

		assertEquals(1, mockedWordCounter.getCount());
		assertEquals(1, mockedUniqueWordCounter.getCount());
		assertEquals(10, mockedWordCalculation.calculateAverageWordLength("some text"));
	}

	private static class MockedWordCounter implements WordCounter {

		private int count;

		@Override
		public int countWords(String text) {
			count++;
			return 0;
		}

		private int getCount() {
			return count;
		}
	}

	private static class MockedReader implements InputTextReader {

		private final String text;

		public MockedReader(String text) {
			this.text = text;
		}

		@Override
		public String readText() throws IOException {
			return text;
		}
	}

	private static class MockedWordCalculation implements WordCalculation {

		@Override
		public double calculateAverageWordLength(String text) {
			return 10;
		}
	}
}
