package sk.app.adaptor;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import sk.app.adaptor.ui.InputTextUserInterface;
import sk.app.application.port.incoming.WordCounter;
import sk.app.application.port.outgoing.InputTextReader;
import sk.app.adaptor.ui.UserInterface;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTextUserInterfaceIntegrationTest {

	@Test
	public void testInputTextUserInterfaceIntegrationTest() throws IOException {

		MockedWordCounter mockedWordCounter = new MockedWordCounter();

		UserInterface userInterface = new InputTextUserInterface(mockedWordCounter, new MockedReader("some text"));
		userInterface.countWords();

		assertEquals(1, mockedWordCounter.getCount());
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
}
