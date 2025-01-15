package integration;

import exception.RequiredFileNotFoundException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reader.LineByLineFileReader;

class LineByLineReaderIntegrationTest {

  private static final String PATH_TO_TEST_FILE = "src/test/resources/testIgnoreWords.txt";
  private LineByLineFileReader lineByLineFileReader;

  @BeforeEach
  void beforeEach() {
    this.lineByLineFileReader = new LineByLineFileReader();
  }

  @Test
  void testCorrectFileRead() {
    final List<String> actualListOfString = this.lineByLineFileReader.read(PATH_TO_TEST_FILE);
    final List<String> expectedListOfString = List.of("oleg", "interview");
    Assertions.assertEquals(expectedListOfString, actualListOfString);
  }

  @Test
  void testNonExistingFileRead() {
    final String nonExisitngPath = "oleg/oleg";
    Assertions.assertThrows(RequiredFileNotFoundException.class, () -> this.lineByLineFileReader.read(nonExisitngPath));
  }
}
