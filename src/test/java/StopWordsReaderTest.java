import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class StopWordsReaderTest {

    @Test
    public void GIVEN_stopWordFile_WHEN_read_THEN_setWithStopwordsReturned() {
        //GIVEN
        StopWordsReader stopWordsReader = new StopWordsReader();

        //WHEN
        Set<String> stopwords = stopWordsReader.read();

        //THEN
        Assertions.assertNotNull(stopwords);
    }

}