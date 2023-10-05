package io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ConsoleTest {

    @Test
    public void consoleIoReadMustReturnTheRightText() {
        String inputText = "Mary had a little lamb";
        Console consoleIO = new Console(new ByteArrayInputStream(inputText.getBytes()));

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
        Console consoleIO = new Console(new ByteArrayInputStream(inputText.getBytes()));

        try {
            String readText = consoleIO.read();
            Assertions.assertEquals(inputText, readText, "ConsoleIO read did not return the right text.");
        } catch (IOException e) {
            Assertions.fail("ConsoleIO read should not throw an error");
        }
    }
}
