import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.CommandService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


public class CommandServiceTest {

    @Test
    public void testGetUserInput() {
        String simulatedInput = "test input\n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());

        PrintStream printStream = new PrintStream(outputStream);

        CommandService commandService = new CommandService(inputStream, printStream);

        String userInput = commandService.getUserInput();

        Assertions.assertEquals("test input", userInput);

        Assertions.assertEquals("Enter text: ",  outputStream.toString());
    }
}
