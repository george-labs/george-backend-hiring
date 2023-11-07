import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputServiceTest {
    InputService inputService;

    @BeforeEach
    void init(){
        inputService = new InputService();
    }

    @Test
    public void InputFileTest() throws IOException {
        String expected = "Mary had\r\n" +
                "a little\r\n" +
                "lamb";
        Path of = Path.of("emptyFile.txt");

        Assertions.assertEquals(expected, inputService.getInput("mytext.txt"));
        Files.createFile(of);
        Assertions.assertEquals("" ,inputService.getInput("emptyFile.txt"));
        Files.delete(of);
    }
}
