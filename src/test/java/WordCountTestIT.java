import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class WordCountTestIT {

    private final static String STOPWORDS_FILE = "src/test/resources/stopwords.txt";
    private final static String EMPTY_STOPWORDS = "src/test/resources/stopwords_empty.txt";

    private final static String MYTEXT_FILE = "src/test/resources/mytext.txt";
    private final static String MYTEXT_FILE_EMPTY = "src/test/resources/mytext_empty.txt";
    @Test
    void when_count_words_with_filter_list_words_are_filtered_out() throws IOException {
        List<String> filterList = TextFileReader.read(STOPWORDS_FILE);
        WordCountResult result = WordCount.count("Mary had a little lamb", filterList);
        Assertions.assertEquals(4, result.getNumberOfWords());
    }

    @Test
    void when_input_is_empty_return_0() throws IOException {
        List<String> filterList = TextFileReader.read(STOPWORDS_FILE);
        WordCountResult result = WordCount.count("", filterList);
        Assertions.assertEquals(0, result.getNumberOfWords());
    }

    @Test
    void when_stopwords_is_empty_word_count_is_not_filtered_out() throws IOException {
        List<String> filterList = TextFileReader.read(EMPTY_STOPWORDS);
        WordCountResult result= WordCount.count("Mary had a little lamb", filterList);
        Assertions.assertEquals(5, result.getNumberOfWords());
    }

    @Test
    void when_input_is_from_file_then_count_words() throws IOException {
        List<String> filterList = TextFileReader.read(STOPWORDS_FILE);
        String text = TextFileReader.read(MYTEXT_FILE, TextFileReader.JOIN_FUNCTION);
        WordCountResult result= WordCount.count(text, filterList);
        Assertions.assertEquals(4, result.getNumberOfWords());
    }

    @Test
    void when_input_file_is_empty_count_words_is_0() throws IOException {
        List<String > filterList = TextFileReader.read(STOPWORDS_FILE);
        String text = TextFileReader.read(MYTEXT_FILE_EMPTY, TextFileReader.JOIN_FUNCTION);
        WordCountResult result = WordCount.count(text, filterList);
        Assertions.assertEquals(0, result.getNumberOfWords());
    }
}
