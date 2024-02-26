import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaApplicationTest {

    @Test
    public void shouldReturnWordCount_whenWordListGiven() {
    	
    	var input = "Test test";
    	var expectedWordCount = 2;
    	int wordCount = JavaApplication.getWordCount(input);
        Assertions.assertTrue(expectedWordCount == wordCount);
    }
    
    @Test
    public void shouldReturnWordCount_whenWordListContainsInvalidWords() {
    	
    	var input = "T3st test 3 4 5";
    	var expectedWordCount = 1;
    	int wordCount = JavaApplication.getWordCount(input);
        Assertions.assertTrue(expectedWordCount == wordCount);
    }
    
    @Test
    public void shouldReturnWordCount_whenEmptyWordListProvided() {
    	
    	var input = "";
    	var expectedWordCount = 0;
    	int wordCount = JavaApplication.getWordCount(input);
        Assertions.assertTrue(expectedWordCount == wordCount);
    }
    
    @Test
    public void shouldReturnWordCount_whenEmptyWordListWithEmptySpacesProvided() {
    	
    	var input = "  ";
    	var expectedWordCount = 0;
    	int wordCount = JavaApplication.getWordCount(input);
        Assertions.assertTrue(expectedWordCount == wordCount);
    }
    
}
