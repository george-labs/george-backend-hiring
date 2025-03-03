import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WordCounterTest {

    private final MockFactory mockFactory = new MockFactory();

    private final WordCounter wordCounter = new WordCounter();

    @Test
    public void countTest(){
        String line = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        // mock stopWords list
        List<String> stopWords = mockFactory.getStopWordsList();
        CountResponse expectedResponse = mockFactory.createCountResponse(7, 6, 6.428571F);

        // asserts
        CountResponse response = wordCounter.count(line, stopWords);
        Assertions.assertEquals(expectedResponse.getUniqueCount(), response.getUniqueCount());
        Assertions.assertEquals(expectedResponse.getTotalCount(), response.getTotalCount());
        Assertions.assertEquals(expectedResponse.getAverageWordLength(), response.getAverageWordLength());

    }

    @Test
    public void countWordsWithMoreSpacesInTextTest(){
        String line = "Humpty-Dumpty sat  on a wall. Humpty-Dumpty   had a great fall.";

        // mock stopWords list
        List<String> stopWords = mockFactory.getStopWordsList();
        CountResponse expectedResponse = mockFactory.createCountResponse(7, 6, 6.428571F);

        // asserts
        CountResponse response = wordCounter.count(line, stopWords);
        Assertions.assertEquals(expectedResponse.getUniqueCount(), response.getUniqueCount());
        Assertions.assertEquals(expectedResponse.getTotalCount(), response.getTotalCount());
        Assertions.assertEquals(expectedResponse.getAverageWordLength(), response.getAverageWordLength());

    }

    @Test
    public void countWithoutStopWordsTest(){
        String line = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";

        // mock stopWords list
        CountResponse expectedResponse = mockFactory.createCountResponse(10, 8, 4.9F);

        // asserts
        CountResponse response = wordCounter.count(line, new ArrayList<>());
        Assertions.assertEquals(expectedResponse.getUniqueCount(), response.getUniqueCount());
        Assertions.assertEquals(expectedResponse.getTotalCount(), response.getTotalCount());
        Assertions.assertEquals(expectedResponse.getAverageWordLength(), response.getAverageWordLength());

    }

    @Test
    public void countWithLineEmptyWordsTest(){
        String line = "";

        // mock stopWords list
        CountResponse expectedResponse = mockFactory.createCountResponse(0, 0, 0);

        // asserts
        CountResponse response = wordCounter.count(line, new ArrayList<>());
        Assertions.assertEquals(expectedResponse.getUniqueCount(), response.getUniqueCount());
        Assertions.assertEquals(expectedResponse.getTotalCount(), response.getTotalCount());
        Assertions.assertEquals(expectedResponse.getAverageWordLength(), response.getAverageWordLength());

    }

    @Test
    public void countWithLineNullTest(){
        String line = null;

        // mock stopWords list
        CountResponse expectedResponse = mockFactory.createCountResponse(0, 0, 0);

        // asserts
        CountResponse response = wordCounter.count(line, new ArrayList<>());
        Assertions.assertEquals(expectedResponse.getUniqueCount(), response.getUniqueCount());
        Assertions.assertEquals(expectedResponse.getTotalCount(), response.getTotalCount());
        Assertions.assertEquals(expectedResponse.getTotalCount(), response.getAverageWordLength());

    }
}
