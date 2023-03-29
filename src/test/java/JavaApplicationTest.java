import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaApplicationTest {

  @Test
  void dummy_test() {

  }

  @Test
  void word_count_should_be_correct() {
    JavaApplication javaApplication = new JavaApplication();

    int wordCount = javaApplication.wordCount("This is a test");
    assertEquals(4, wordCount);

    wordCount = javaApplication.wordCount(" ");
    assertEquals(0, wordCount);

    wordCount = javaApplication.wordCount("    This is    a test");
    assertEquals(4, wordCount);

    wordCount = javaApplication.wordCount(null);
    assertEquals(0, wordCount);

  }

}
