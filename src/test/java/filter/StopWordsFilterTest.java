package filter;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;


public class StopWordsFilterTest {
	
	private static final String STOPWORDS = "the a on off";
	
	private Filter filter = new StopWordsFilter(); 
	
	@Test 
	public void shouldReturnFilteredResult_whenValidInputWithStopwordsProvided() {
		var input = List.of("abcd", "the");
		var expectedOutcome = 1;
		var res = filter.filter(input);
		assertTrue(res.size()== expectedOutcome);
	}

	@Test 
	public void shouldReturnEmpty_whenInputContainsStopWordsOnly() {
		var input = List.of("the", "a", "off");
		var expectedOutcome = 0;
		var res = filter.filter(input);
		assertTrue(res.size() == expectedOutcome);
	}
	
	@Test 
	public void shouldReturnFilteredResult_whenEmptyInputContainsEmptySpace() {
		var input = List.of(" ");
		var expectedOutcome = 1;
		var res = filter.filter(input);
		assertTrue(res.size()== expectedOutcome);
	}
	
	@Test 
	public void shouldReturnEmptyResult_whenEmptyInputProvided() {
		var expectedOutcome = 0;
		var res = filter.filter(Collections.emptyList());
		assertTrue(res.size()== expectedOutcome);
	}

}
