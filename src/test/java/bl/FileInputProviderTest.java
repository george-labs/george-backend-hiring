package bl;

import bl.providers.FileInputProvider;
import org.junit.jupiter.api.Test;
import utils.InputFileUtils;

import static org.junit.jupiter.api.Assertions.*;

class FileInputProviderTest {

    @Test
    public void testCanReadFile() {
        FileInputProvider provider = new FileInputProvider(InputFileUtils.getInputFile());
        String input = provider.getInput();
        assertFalse(input.isEmpty());
    }

    @Test
    public void testInvalidFileName() {
        FileInputProvider provider = new FileInputProvider("invalidname.txt");
        Exception exception = assertThrows(IllegalArgumentException.class, provider::getInput);

        assertEquals("File \"invalidname.txt\" does not exist.", exception.getMessage());
    }
}