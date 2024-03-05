package bl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCountAppTest {

    private WordCountApp app;

    @BeforeEach
    public void init() {
        app = new WordCountApp();
    }

    @Test
    public void testInputFileProcessed() {
        app.run("input.txt");
    }

    @Test
    public void testInvalidInputFile() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.run("invalidname.txt");
        });

        assertEquals("File \"invalidname.txt\" does not exist.", exception.getMessage());
    }
}
