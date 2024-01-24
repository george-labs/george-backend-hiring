import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import providers.FileInputDataProvider;
import providers.IDataProvider;
import rules.IRule;
import rules.OnlyLetterRule;
import rules.StopWordsRule;
import utils.Constants;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

class RuleTest {
    private IDataProvider fileInputDataProvider;


    @BeforeEach
    public void init() {
        fileInputDataProvider = new FileInputDataProvider(Constants.STOP_WORDS_LIST_FILE);
    }

    @Test
    void getStopWordsRuleTest() throws IOException {
        String[] stopWords = fileInputDataProvider.getData().split(Constants.REGEX);
        IRule stopWordsRule = new StopWordsRule(new HashSet<>(Arrays.asList(stopWords)));
        Assertions.assertFalse(stopWordsRule.isValid("off"));
        Assertions.assertTrue(stopWordsRule.isValid("Eugene"));

    }

    @Test
    void getOnlyLetterRuleTest() {
        IRule onlyLetterRule = new OnlyLetterRule();
        Assertions.assertFalse(onlyLetterRule.isValid("aaa-bbb"));
        Assertions.assertTrue(onlyLetterRule.isValid("aa"));
    }
}
