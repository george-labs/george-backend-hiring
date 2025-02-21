package sk.erste.wordcountkata;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTextReaderTest {

    @Test
    public void testGetInputText() throws FileNotFoundException {
        InputTextReader inputTextReader = new InputTextReader("mytext_test.txt");
        assertEquals("Mary had\na little\nlamb", inputTextReader.getInputText());
    }

    @Test
    public void testGetInputText_emptyFile() throws FileNotFoundException {
        InputTextReader inputTextReader = new InputTextReader("mytext_test_empty.txt");
        assertEquals("", inputTextReader.getInputText());
    }

    @Test
    public void testGetInputText_emptyLine() throws FileNotFoundException {
        InputTextReader inputTextReader = new InputTextReader("mytext_test_emptyline.txt");
        assertEquals("Mary had\n\n\nlamb", inputTextReader.getInputText());
    }

    @Test
    public void testGetInputText_whenFileNotExists() {
        InputTextReader inputTextReader = new InputTextReader("mytext.txt_notexists");
        assertThrows(FileNotFoundException.class, inputTextReader::getInputText);
    }

    @Test
    public void testGetInputText_whenConsole() throws FileNotFoundException {
        System.setIn(new ByteArrayInputStream("Mary had a little lamb".getBytes()));
        InputTextReader inputTextReader = new InputTextReader(null);
        assertEquals("Mary had a little lamb", inputTextReader.getInputText());
    }
}
