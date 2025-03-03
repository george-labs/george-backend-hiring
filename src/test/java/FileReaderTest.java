import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FileReaderTest {

    private final FileReader fileReader = new FileReader();

    private final MockFactory mockFactory = new MockFactory();

    @Test
    public void getContentTest(){
        String path = "src/test/resources/mytext.txt";
        String expectedValue = "Mary had a little pony ";

        Assertions.assertEquals(expectedValue, fileReader.getContent(path));
    }


    @Test
    public void getStopWordsTest(){
        String path = "src/test/resources/stopwordstestfile.txt";
        List<String> stopWords = mockFactory.getStopWordsList();

        List<String> stopWordsResponse = fileReader.getStopWords(path);

        Assertions.assertNotNull(stopWordsResponse);
        Assertions.assertEquals(stopWords.size(), stopWordsResponse.size());
        Assertions.assertTrue(stopWords.size() == stopWordsResponse.size()
                && stopWords.containsAll(stopWordsResponse)
                && stopWordsResponse.containsAll(stopWords));
    }

}
