import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class WordCountTestIT {

    private final String STOPWORDS_FILE = "src/test/resources/stopwords.txt";
    private final String EMPTY_STOPWORDS = "src/test/resources/stopwords_empty.txt";
    @Test
    void when_count_words_with_filter_list_words_are_filtered_out() throws IOException {
        StopWordReader stopWordReader = new StopWordReader(STOPWORDS_FILE);
        stopWordReader.read();
        List<String> filterList = stopWordReader.getWordsToFilterOut();
        WordCount wordCount = new WordCount();
        Long numberWords = wordCount.count("Mary had a little lamb", filterList);
        Assertions.assertEquals(4, numberWords);
    }

    @Test
    void when_input_is_empty_return_0() throws IOException {
        StopWordReader stopWordReader = new StopWordReader(STOPWORDS_FILE);
        stopWordReader.read();
        WordCount wordCount = new WordCount();
        Long numberWords = wordCount.count("", stopWordReader.getWordsToFilterOut());
        Assertions.assertEquals(numberWords, 0);
    }

    @Test
    void when_stopwords_is_empty_word_count_is_not_filtered_out() throws IOException {
        StopWordReader stopWordReader = new StopWordReader(EMPTY_STOPWORDS);
        stopWordReader.read();
        WordCount wordCount = new WordCount();
        Long numberWords = wordCount.count("Mary had a little lamb", stopWordReader.getWordsToFilterOut());
        Assertions.assertEquals(5, numberWords);
    }
}
