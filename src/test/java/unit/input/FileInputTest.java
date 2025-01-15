package unit.input;

import input.FileInput;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unit.mocks.MockedFileReader;

class FileInputTest {

  private MockedFileReader mockedFileReader;
  private FileInput fileInput;

  @BeforeEach
  void beforeEach() {
    this.mockedFileReader = new MockedFileReader();
    this.fileInput = new FileInput(mockedFileReader, "mockedPath");
  }

  @Test
  void testNonEmptyInput() throws IOException {
    final List<String> testInput = List.of("oleg is", "on the", "interview");
    this.mockedFileReader.setMockedList(testInput);
    final String actualConcatinatedString = this.fileInput.input();
    final String expectedConcatinatedString = "oleg is on the interview";
    Assertions.assertEquals(expectedConcatinatedString, actualConcatinatedString);
  }

  @Test
  void testEmptyInput() throws IOException {
    final List<String> testInput = List.of();
    this.mockedFileReader.setMockedList(testInput);
    final String actualConcatinatedString = this.fileInput.input();
    final String expectedConcatinatedString = "";
    Assertions.assertEquals(expectedConcatinatedString, actualConcatinatedString);
  }

  @Test
  void testNullInput() {
    final List<String> testInput = null;
    this.mockedFileReader.setMockedList(testInput);
    Assertions.assertThrows(NullPointerException.class, () -> this.fileInput.input());
  }
}
