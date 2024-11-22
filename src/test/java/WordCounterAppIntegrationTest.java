import input.ConsoleScanner;
import input.InputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static reporter.SimpleStringReporter.WORD_COUNT_MESSAGE;


class WordCounterAppIntegrationTest {

    private InputStream inputStream;
    private InputReader inputReader;
    WordCounterApp app;


    @Test
    void runTest() {
        String originalInput = "Marry had a little lamb and a dog";
        inputStream = new ByteArrayInputStream(originalInput.getBytes());
        inputReader = new InputReader(new ConsoleScanner(new Scanner(inputStream)));

        app = new WordCounterApp(inputReader, "stopwords.txt");
        String result = app.run();

        Assertions.assertEquals(WORD_COUNT_MESSAGE + 5, result);

    }

}