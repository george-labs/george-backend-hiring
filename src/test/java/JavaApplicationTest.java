import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

public class JavaApplicationTest {

	@Test
	public void testWhenOneUppercaseWordThenCountEquals1() {
		assertEquals(1, JavaApplication.getWordsCount("HELLO"));
	}
	
	@Test
	public void testWhenOneLowercaseWordThenCountEquals1() {
		assertEquals(1, JavaApplication.getWordsCount("hello"));
	}
	
	@Test
	public void testWhenOneMixedcaseWordThenCountEquals1() {
		assertEquals(1, JavaApplication.getWordsCount("Hello"));
	}

	@Test
	public void testWhenOneWordWithDigitThenCountEquals0() {
		assertEquals(0, JavaApplication.getWordsCount("He2o"));
	}
	
	@Test
	public void testWhenOneWordWithDollarThenCountEquals0() {
		assertEquals(0, JavaApplication.getWordsCount("He$o"));
	}

	@Test
	public void testWhenMoreWordsWithSpacesThenCountEqualsWordsCount() {
		assertEquals(3, JavaApplication.getWordsCount("Hello and hi world."));
	}

	@Test
	public void testWhenMixedAlloweAndNotAlloweWordsThenCountEqualsAllowedWordsCount() {
		assertEquals(2, JavaApplication.getWordsCount("Hello and hi5 world."));
	}
	
	@Test
	public void testWhenMoreWordsWithWhiteCharsThenCountEqualsWordsCount() {
		assertEquals(3, JavaApplication.getWordsCount("Hello\tand hi world."));
	}
}
