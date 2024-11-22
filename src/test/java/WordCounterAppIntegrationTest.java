import input.OneLineScanner;
import input.InputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static reporter.SimpleStringReporter.WORD_COUNT_MESSAGE;


class WordCounterAppIntegrationTest {

    WordCounterApp app;

    @Test
    void runTest() {
        String originalInput = "Marry had a little lamb and a dog";
        InputStream inputStream = new ByteArrayInputStream(originalInput.getBytes());
        InputReader inputReader = new InputReader(new OneLineScanner(new Scanner(inputStream)));

        app = new WordCounterApp(inputReader, "stopwords.txt");
        String result = app.run();

        Assertions.assertEquals(WORD_COUNT_MESSAGE + 5, result);

    }

}