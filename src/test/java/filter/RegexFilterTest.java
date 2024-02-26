package filter;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class RegexFilterTest {
	
	private Filter filter = new RegexFilter(); 
	
	@Test 
	public void shouldReturnFilteredResult_whenValidInputProvided() {
		var input = List.of("abcd");
		var expectedOutcome = 1;
		var res = filter.filter(input);
		assertTrue(res.size()== expectedOutcome);
	}

	@Test 
	public void shouldReturnFilteredResult_whenInputContainsInvalidWords() {
		var input = List.of("abcd", "abc1234", "1234");
		var expectedOutcome = 1;
		var res = filter.filter(input);
		assertTrue(res.size() == expectedOutcome);
	}
	
	@Test 
	public void shouldReturnEmptyResult_whenEmptyInputProvided() {
		var input = List.of("");
		var expectedOutcome = 0;
		var res = filter.filter(input);
		assertTrue(res.size()== expectedOutcome);
	}

}
