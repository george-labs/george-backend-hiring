package managers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FileManagerTest {

  @Test
  void test_loadTextFromFile_fileExists() {
    // given
    String fileName = "mytext.txt";

    // space at the end because of logic in loading text from file
    // after every line we add space
    String expected = "Mary had a little lamb ";

    // when
    String result = FileManager.loadTextFromFile(fileName);

    assertEquals(expected, result);
  }

  @Test
  void test_isFileInOurResources_true() {
    // given
    String fileName = "mytext.txt";

    // when
    boolean result = FileManager.isFileInOurResources(fileName);

    assertTrue(result);
  }

  @Test
  void test_isFileInOurResources_false() {
    // given
    String fileName = "nonExisting.txt";

    // when
    boolean result = FileManager.isFileInOurResources(fileName);

    assertFalse(result);
  }
}
