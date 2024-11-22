import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class WordCounterAppIntegrationTest {

    WordCounterApp app = new WordCounterApp("stopwords.txt");

    @Test
    void runTest(){
        String result = app.run();
        Assertions.assertEquals();

    }

}