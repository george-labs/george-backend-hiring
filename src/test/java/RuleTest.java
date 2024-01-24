import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import providers.FileInputDataProvider;
import providers.IDataProvider;
import rules.StopWordsRule;

import java.io.IOException;

public class RuleTest {
    @Test
    public void checkFileReader() throws IOException {
        IDataProvider inputDataProvider = new FileInputDataProvider("stopwords.txt");
        Assertions.assertNotNull(inputDataProvider.getData());

    }
}
