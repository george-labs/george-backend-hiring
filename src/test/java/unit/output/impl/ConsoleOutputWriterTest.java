package unit.output.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import output.impl.ConsoleOutputWriter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleOutputWriterTest {

    private ConsoleOutputWriter consoleOutputWriter;
    private final ByteArrayOutputStream byteArrayOutputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        consoleOutputWriter = new ConsoleOutputWriter();
    }

    @Test
    void givenRegularText_whenWriteLine_thanShouldOutputRegularText() {
        System.setOut(new PrintStream(byteArrayOutputStreamCaptor));

        consoleOutputWriter.writeLine("Some text");

        assertEquals("Some text\n", byteArrayOutputStreamCaptor.toString());
    }

    @Test
    void givenNullText_whenWriteLine_thanShouldOutputNullText() {
        System.setOut(new PrintStream(byteArrayOutputStreamCaptor));

        consoleOutputWriter.writeLine(null);

        assertEquals("null\n", byteArrayOutputStreamCaptor.toString());
    }

}
