package wordcount.stopwordsreader;

import org.junit.jupiter.api.Test;
import wordcount.FileReader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StopWordsReaderTest {

    @Test
    void raed() {
        FileReader fileReader = new StopWordsReader();
        assertEquals(List.of("the", "a", "on", "off"), fileReader.raed());
    }
}