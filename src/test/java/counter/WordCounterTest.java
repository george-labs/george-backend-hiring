package counter;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filter.Filter;
import filter.FilterService;
import filter.RegexFilter;
import filter.StopWordsFilter;
import filter.WordFilterService;
import utils.MockedInputProvider;
import wordcount.input.InputProvider;

public class WordCounterTest {
	
	private InputProvider inputProvider;
	private FilterService filterService;
	private List<Filter> filters = new ArrayList<>();
	private Counter counter;
	
	
	@BeforeEach
	public void setup() {
		Filter regexFilter = new RegexFilter();
		Filter stopwordsFilter = new StopWordsFilter();
		filterService = new WordFilterService();
		
		filters.add(regexFilter);
		filters.add(stopwordsFilter);
	}

    @Test
    public void shouldReturnWordCount_whenWordListGiven() {
    	var input = "abc abc";
    	var expectedWordCount = 2;
    	
    	inputProvider = new MockedInputProvider(input);
    	counter = new WordCounter(inputProvider, filters);
    	var res = counter.count();
    	
        Assertions.assertTrue(expectedWordCount == res.getCount());
    }
    
    @Test
    public void shouldReturnWordCount_whenWordListContainsValidWordsWithMultipleStopwords() {
    	var input = "abc abc the a";
    	var expectedWordCount = 2;
    	
    	inputProvider = new MockedInputProvider(input);
    	counter = new WordCounter(inputProvider, filters);
    	var res = counter.count();
    	
        Assertions.assertTrue(expectedWordCount == res.getCount());
    }
    
    @Test
    public void shouldReturnWordCount_whenWordListContainsValidWordsWithSingleStopword() {
    	var input = "abc a";
    	var expectedWordCount = 1;
    	
    	inputProvider = new MockedInputProvider(input);
    	counter = new WordCounter(inputProvider, filters);
    	var res = counter.count();
    	
        Assertions.assertTrue(expectedWordCount == res.getCount());
    }
    
    @Test
    public void shouldReturnWordCount_whenWordListContainsValidWords_startingAndEndingWithEmptySpaces() {
    	var input = " abc a ";
    	var expectedWordCount = 1;
    	
    	inputProvider = new MockedInputProvider(input);
    	counter = new WordCounter(inputProvider, filters);
    	var res = counter.count();
    	
        Assertions.assertTrue(expectedWordCount == res.getCount());
    }
    
    @Test
    public void shouldReturnWordCount_whenWordListContainsInvalidWords() {
    	var input = "T3st test 3 4 5";
    	var expectedWordCount = 1;
    	
    	inputProvider = new MockedInputProvider(input);
    	counter = new WordCounter(inputProvider, filters);
    	var res = counter.count();
    	
        Assertions.assertTrue(expectedWordCount == res.getCount());
    }
    
    @Test
    public void shouldReturnWordCount_whenEmptyWordListProvided() {
    	var input = "";
    	var expectedWordCount = 0;
    	
    	inputProvider = new MockedInputProvider(input);
    	counter = new WordCounter(inputProvider, filters);
    	var res = counter.count();
    	
        Assertions.assertTrue(expectedWordCount == res.getCount());
    }
    
    @Test
    public void shouldReturnWordCount_whenEmptyWordListWithEmptySpacesProvided() {
    	var input = "  ";
    	var expectedWordCount = 0;
    	
    	inputProvider = new MockedInputProvider(input);
    	counter = new WordCounter(inputProvider, filters);
    	var res = counter.count();
    	
        Assertions.assertTrue(expectedWordCount == res.getCount());
    }
	
	
}
