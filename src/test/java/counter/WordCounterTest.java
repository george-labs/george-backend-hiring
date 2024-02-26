package counter;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filter.Filter;
import filter.FilterService;
import filter.RegexFilter;
import filter.StopWordsFilter;
import filter.StopWordsFilterTest;
import filter.WordFilterService;
import utils.MockedInputProvider;
import wordcount.input.InputProvider;

public class WordCounterTest {
	
	private InputProvider inputProvider;
	private FilterService filterService;
	private Counter counter;
	
	
	@BeforeEach
	public void setup() {
		Filter regexFilter = new RegexFilter();
		Filter stopwordsFilter = new StopWordsFilter();
		filterService = new WordFilterService();
		filterService.registerFilter(regexFilter);
		filterService.registerFilter(stopwordsFilter);
	}

    @Test
    public void shouldReturnWordCount_whenWordListGiven() {
    	var input = generateNValidWords(2);
    	var expectedWordCount = 2;
    	
    	inputProvider = new MockedInputProvider(input);
    	counter = new WordCounter(inputProvider, filterService);
    	var res = counter.count();
    	
        Assertions.assertTrue(expectedWordCount == res.getCount());
    }
    
    @Test
    public void shouldReturnWordCount_whenWordListContainsValidWordsWithMultipleStopwords() {
    	var validWords = generateNValidWords(2);
    	var stopwrds = getRandomStopWord();
    	var input = String.format("%s %s", validWords, stopwrds);
    	var expectedWordCount = 2;
    	
    	inputProvider = new MockedInputProvider(input);
    	counter = new WordCounter(inputProvider, filterService);
    	var res = counter.count();
    	
        Assertions.assertTrue(expectedWordCount == res.getCount());
    }
    
    @Test
    public void shouldReturnWordCount_whenWordListContainsValidWordsWithSingleStopword() {
    	var validWords = generateNValidWords(1);
    	var stopwrds = getRandomStopWord();
    	var input = String.format("%s %s", validWords, stopwrds);
    	var expectedWordCount = 1;
    	
    	inputProvider = new MockedInputProvider(input);
    	counter = new WordCounter(inputProvider, filterService);
    	var res = counter.count();
    	
        Assertions.assertTrue(expectedWordCount == res.getCount());
    }
    
    @Test
    public void shouldReturnWordCount_whenWordListContainsValidWords_startingAndEndingWithEmptySpaces() {
    	var validWords = generateNValidWords(1);
    	var stopwrds = getRandomStopWord();
    	var input = String.format(" %s %s ", validWords, stopwrds);
    	var expectedWordCount = 1;
    	
    	inputProvider = new MockedInputProvider(input);
    	counter = new WordCounter(inputProvider, filterService);
    	var res = counter.count();
    	
        Assertions.assertTrue(expectedWordCount == res.getCount());
    }
    
    @Test
    public void shouldReturnWordCount_whenWordListContainsInvalidWords() {
    	var validWords = generateNValidWords(1);
    	var invalidWords = generateNInvalidWord(3);
    	var stopwrds = getRandomStopWord();
    	var input = String.format("%s %s %s ", validWords, invalidWords, stopwrds);
    	var expectedWordCount = 1;
    	
    	inputProvider = new MockedInputProvider(input);
    	counter = new WordCounter(inputProvider, filterService);
    	var res = counter.count();
    	
        Assertions.assertTrue(expectedWordCount == res.getCount());
    }
    
    @Test
    public void shouldReturnWordCount_whenEmptyWordListProvided() {
    	var input = "";
    	var expectedWordCount = 0;
    	
    	inputProvider = new MockedInputProvider(input);
    	counter = new WordCounter(inputProvider, filterService);
    	var res = counter.count();
    	
        Assertions.assertTrue(expectedWordCount == res.getCount());
    }
    
    @Test
    public void shouldReturnWordCount_whenEmptyWordListWithEmptySpacesProvided() {
    	var input = "  ";
    	var expectedWordCount = 0;
    	
    	inputProvider = new MockedInputProvider(input);
    	counter = new WordCounter(inputProvider, filterService);
    	var res = counter.count();
    	
        Assertions.assertTrue(expectedWordCount == res.getCount());
    }
    
    private String generateNValidWords(Integer n) {
    	return "abc ".repeat(n);
    }
    
    private String generateNInvalidWord(Integer n) {
    	return "abc123 ".repeat(n);
    }
	
    private String getRandomStopWord() {
    	var stopWords = StopWordsFilterTest.STOPWORDS.split(" ");
    	return Arrays.asList(stopWords).stream().findAny().get();
    }
}
