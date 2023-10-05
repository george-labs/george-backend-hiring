package io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ConsoleIOTest {

    @Test
    public void consoleIoReadMustReturnTheRightText() {
        String inputText = "Mary had a little lamb";
        ConsoleIO consoleIO = new ConsoleIO(new ByteArrayInputStream(inputText.getBytes()));

        try {
            String readText = consoleIO.read();
            Assertions.assertEquals(inputText, readText, "ConsoleIO read did not return the right text.");
        } catch (IOException e) {
            Assertions.fail("ConsoleIO read should not throw an error");
        }
    }

    @Test
    public void consoleIoReadMustHandleEmptyText() {
        String inputText = "";
        ConsoleIO consoleIO = new ConsoleIO(new ByteArrayInputStream(inputText.getBytes()));

        try {
            String readText = consoleIO.read();
            Assertions.assertEquals(inputText, readText, "ConsoleIO read did not return the right text.");
        } catch (IOException e) {
            Assertions.fail("ConsoleIO read should not throw an error");
        }
    }
}
