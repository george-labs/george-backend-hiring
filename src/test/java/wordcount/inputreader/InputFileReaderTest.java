package wordcount.inputreader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputFileReaderTest {

    @Test
    void readInput() {
        InputFileReader inputFileReader = new InputFileReader("mytext.txt");
        assertEquals("Mary had a little lamb", inputFileReader.readInput());
    }
}
