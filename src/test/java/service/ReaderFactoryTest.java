package service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReaderFactoryTest {

    ReaderFactory underTest;

    @Test
    public void createReaderCreatesCommandLineReaderTest() {
        underTest = new ReaderFactory();

        Reader reader = underTest.createReader(new String[]{});

        assertEquals(reader.getClass(), CommandLineReader.class);
    }

    @Test
    public void createReaderCreatesFileReaderWhenMissingFileTest() {
        underTest = new ReaderFactory();

        Reader reader = underTest.createReader(new String[]{"notexistingfile.txt"});

        assertEquals(reader.getClass(), CommandLineReader.class);
    }

    @Test
    public void createReaderCreatesFileReaderWhenFileExistsTest() {
        underTest = new ReaderFactory();

        Reader reader = underTest.createReader(new String[]{"onlyrealwords.txt"});

        assertEquals(reader.getClass(), FileReader.class);
    }
}
