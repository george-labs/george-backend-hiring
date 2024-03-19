package interview.business;

import interview.reader.ConsoleInputReader;
import interview.reader.InputReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Xenofon Zinoviou
 */
class WordCounterTest {

    private InputReader inputReader;

    private WordCounter testClass;

    @Test
    void test_SimpleCase(){
        String text = "adf adf!adf jk! jlkj.";

        inputReader = new ConsoleInputReader(getInputStream(text));

        testClass = new WordCounter(inputReader);

        testClass.processInput();
    }

    private InputStream getInputStream(String text) {
        return new ByteArrayInputStream(text.getBytes());
    }

}
