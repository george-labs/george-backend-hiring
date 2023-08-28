package gyurix.wordcount;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class WordCounterConsoleRunnerTest {

  @Test
  public void testNoArgs() {
    WordCounterConsoleRunner consoleRunner = new WordCounterConsoleRunner(new String[0]);
    assertNull(consoleRunner.getFileName());
    assertFalse(consoleRunner.isIndex());
  }

  @Test
  public void testIndex() {
    WordCounterConsoleRunner consoleRunner = new WordCounterConsoleRunner(new String[]{"-index"});
    assertNull(consoleRunner.getFileName());
    assertTrue(consoleRunner.isIndex());
  }

  @Test
  public void testFileIndexFirst() {
    WordCounterConsoleRunner consoleRunner = new WordCounterConsoleRunner(new String[]{"-index", "test.txt"});
    assertEquals("test.txt", consoleRunner.getFileName());
    assertTrue(consoleRunner.isIndex());
  }

  @Test
  public void testFileIndexLast() {
    WordCounterConsoleRunner consoleRunner = new WordCounterConsoleRunner(new String[]{"test.txt", "-index"});
    assertEquals("test.txt", consoleRunner.getFileName());
    assertTrue(consoleRunner.isIndex());
  }

  @Test
  public void testFile() {
    WordCounterConsoleRunner consoleRunner = new WordCounterConsoleRunner(new String[]{"test.txt"});
    assertEquals("test.txt", consoleRunner.getFileName());
    assertFalse(consoleRunner.isIndex());
  }

  @Test
  public void testIndexOutput() {
    PrintStream oldOutput = System.out;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    PrintStream newOutput = new PrintStream(bos);
    System.setOut(newOutput);
    new WordCounterConsoleRunner(new String[]{"mytext.txt", "-index"}).run();
    System.setOut(oldOutput);
    assertEquals("Number of words: 4, unique: 4, average word length: 4.25 characters\n" +
            "Index:\n" +
            "had\n" +
            "lamb\n" +
            "little\n" +
            "Mary\n", bos.toString().replace("\r", ""));
  }

  @Test
  public void testDictionary() {
    PrintStream oldOutput = System.out;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    PrintStream newOutput = new PrintStream(bos);
    System.setOut(newOutput);
    new WordCounterConsoleRunner(new String[]{"mytext.txt", "-index", "-dictionary=dict.txt"}).run();
    System.setOut(oldOutput);
    assertEquals("Number of words: 4, unique: 4, average word length: 4.25 characters\n" +
            "Index (unknown: 2):\n" +
            "had\n" +
            "lamb*\n" +
            "little\n" +
            "Mary*\n", bos.toString().replace("\r", ""));
  }

  @Test
  public void testMultipleInputs() {
    PrintStream oldOutput = System.out;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    PrintStream newOutput = new PrintStream(bos);
    System.setOut(newOutput);

    InputStream oldInput = System.in;
    System.setIn(new ByteArrayInputStream("first test\nsecond test\nthird one test\n\n".getBytes(StandardCharsets.UTF_8)));
    new WordCounterConsoleRunner(new String[0]).run();
    System.setOut(oldOutput);
    System.setIn(oldInput);
    assertEquals("Enter text: Number of words: 2, unique: 2, average word length: 4.5 characters\n" +
            "Enter text: Number of words: 2, unique: 2, average word length: 5 characters\n" +
            "Enter text: Number of words: 3, unique: 3, average word length: 4 characters\n" +
            "Enter text: ", bos.toString().replace("\r", ""));
  }
}
