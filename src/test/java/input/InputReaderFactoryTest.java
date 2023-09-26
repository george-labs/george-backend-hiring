package input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputReaderFactoryTest {

    @Test
    public void testCreateUserInputReader() {
        String[] args = new String[]{};

        var createdInputReader = new InputReaderFactory().createInputReader(args);

        Assertions.assertInstanceOf(UserInputReader.class, createdInputReader);
    }

    @Test
    public void testCreateFileInputReader() {
        String[] args = new String[]{"somefile.txt"};

        var createdInputReader = new InputReaderFactory().createInputReader(args);

        Assertions.assertInstanceOf(FileInputReader.class, createdInputReader);
    }

    @Test
    public void testCreateUserInputReaderOnNullInput() {
        String[] args = null;

        var createdInputReader = new InputReaderFactory().createInputReader(args);

        Assertions.assertInstanceOf(UserInputReader.class, createdInputReader);
    }

    @Test
    public void testCreateUserInputReaderOnInvalidInput() {
        String[] args = new String[]{"these arguments are not valid"};

        var createdInputReader = new InputReaderFactory().createInputReader(args);

        Assertions.assertInstanceOf(UserInputReader.class, createdInputReader);
    }
}
