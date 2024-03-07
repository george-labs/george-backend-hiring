package wordcount.counter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CharacterWordCounterTest {

	private static Stream<Arguments> getTestArguments() {
		return Stream.of(
				Arguments.of("Mary had a little lamb", 5), 
				Arguments.of("", 0),
				Arguments.of(" Mary", 1),
				Arguments.of("Mary ", 1),
				Arguments.of("w0rd test", 1),
				Arguments.of(".word test", 1),
				Arguments.of("word) test", 1),
				Arguments.of("❤️ test", 1),
				Arguments.of("Mary 		test", 2));
	}

	@ParameterizedTest
	@MethodSource("getTestArguments")
	void countWordsWithDifferentInputs(String text, long count) {
		FilteredWordCounter wordCounter = new CharacterWordCounter();

		WordCountResult expectedCount = wordCounter.countWords(text);

		assertEquals(expectedCount.getNumberOfWords(), count);
	}

	// TODO testcase for counting unique words
	
}
