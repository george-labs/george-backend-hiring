import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import providers.FileInputDataProvider;
import providers.IDataProvider;
import rules.IRule;
import rules.StopWordsRule;
import utils.Constants;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class RuleTest {
    private IDataProvider inputDataProvider;
    @BeforeEach
    public void init(){
         inputDataProvider = new FileInputDataProvider(Constants.STOP_WORDS_LIST_FILE);
    }
    @Test
    public void checkFileReader() throws IOException {

        Assertions.assertNotNull(inputDataProvider.getData());
    }
    @Test
    public void getStopWords() throws IOException {
        String[] stopWords = inputDataProvider.getData().split(Constants.REGEX);
        Assertions.assertEquals(4, stopWords.length);

    }
    @Test
    public void getStopWordsRule() throws IOException {
        String[] stopWords = inputDataProvider.getData().split(Constants.REGEX);
        IRule stopWordsRule = new StopWordsRule(new HashSet<>(Arrays.asList(stopWords)));
        Assertions.assertFalse(stopWordsRule.isValid("off"));
    }
}
