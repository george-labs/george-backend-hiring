import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class StopWordsServiceTest {

    @Test
    void when_there_are_some_words_in_stopwords_file_then_they_are_correctly_parsed() {
        MockTextFileReadingService mockTextFileReadingService = new MockTextFileReadingService("the\n" +
                "a\n" +
                "on\n" +
                "off");
        StopWordsService stopWordsService = new StopWordsService(mockTextFileReadingService);

        var stopWords = stopWordsService.getStopWords("");

        Assertions.assertEquals(4, stopWords.size());
    }

}