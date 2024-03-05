package bl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCountServiceImplTest {

    @Test
    public void testWordCount() {
        WordCountService countService = new WordCountServiceImpl();

        String input = "this is a test STRING wIth a inval1d  w+rds and + characters\nand new line";
        long count = countService.countWords(input);

        assertEquals(12, count);
    }
}