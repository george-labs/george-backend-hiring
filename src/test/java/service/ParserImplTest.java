package service;

import model.Input;
import model.Words;
import org.junit.jupiter.api.Test;
import service.impl.ParserImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserImplTest {

    private final Parser parser = new ParserImpl();

    @Test
    void testGivenFiveWordsOutputFive() {
        int expectedResult = 5;
        Input input = new Input("Mary had a little lamb");

        Words words = parser.parse(input);

        assertEquals(expectedResult, words.getCountedWords());
    }

    @Test
    void testGivenEmptyStringOutputZero() {
        int expectedResult = 0;
        Input input = new Input("");

        Words words = parser.parse(input);

        assertEquals(expectedResult, words.getCountedWords());
    }

    @Test
    void testGivenThreeWhitespaedStringsOutputOne() {
        int expectedResult = 1;
        Input input = new Input("Three $ overall!");

        Words words = parser.parse(input);

        assertEquals(expectedResult, words.getCountedWords());
    }

}
