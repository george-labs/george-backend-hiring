package it;

import application.JavaApplication;
import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.charset.Charset;

public class JavaApplicationIT {

    private InputStream inputStream;
    private PrintStream outputStream;

    @BeforeEach
    public void initSystemInAndSystemOut() {
        this.inputStream = System.in;
        this.outputStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteArrayOutputStream);
        System.setOut(out);
    }

    @AfterEach
    public void SetSystemInAndSystemOutToDefault() {
        System.setIn(inputStream);
        System.setOut(outputStream);
    }

    @Test
    @DisplayName("Read input from user input. Output should be 5")
    public void testFileReaderFromUserInput() {
        InputStream inputs = new ByteArrayInputStream("Mary had a little lamb".getBytes());
        System.setIn(inputs);
        String[] emptyArgs = {};
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteArrayOutputStream);
        System.setOut(out);

        JavaApplication.main(emptyArgs);

        String[] consoleOutput = byteArrayOutputStream.toString(Charset.defaultCharset()).trim().split(": ");

        Assertions.assertEquals("5", consoleOutput[consoleOutput.length - 1]);
    }
}
