package input;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TerminalInputTest {

  private TerminalInput terminalInput;

  @Test
  void testNonEmptyInputString() throws IOException {
    final String testInput = "OLEG";
    try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(testInput.getBytes())) {
      this.terminalInput = new TerminalInput(byteArrayInputStream);
      final String actualInput = this.terminalInput.input();
      Assertions.assertEquals(testInput, actualInput);
    }
  }

  @Test
  void testEmptyInputString() throws IOException {
    final String testInput = "";
    try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(testInput.getBytes())) {
      this.terminalInput = new TerminalInput(byteArrayInputStream);
      final String actualInput = this.terminalInput.input();
      final String expectedString = null;
      Assertions.assertEquals(expectedString, actualInput);
    }
  }
}