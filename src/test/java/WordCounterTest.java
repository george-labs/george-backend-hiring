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
        CountResponse expectedResponse = mockFactory.createCountResponse(7, 6);

        // asserts
        Assertions.assertEquals(expectedResponse.getUniqueCount(), wordCounter.count(line, stopWords).getUniqueCount());
        Assertions.assertEquals(expectedResponse.getTotalCount(), wordCounter.count(line, stopWords).getTotalCount());

    }

    @Test
    public void countWordsWithMoreSpacesInTextTest(){
        String line = "Humpty-Dumpty sat  on a wall. Humpty-Dumpty   had a great fall.";

        // mock stopWords list
        List<String> stopWords = mockFactory.getStopWordsList();
        CountResponse expectedResponse = mockFactory.createCountResponse(7, 6);

        // asserts
        Assertions.assertEquals(expectedResponse.getUniqueCount(), wordCounter.count(line, stopWords).getUniqueCount());
        Assertions.assertEquals(expectedResponse.getTotalCount(), wordCounter.count(line, stopWords).getTotalCount());

    }

    @Test
    public void countWithoutStopWordsTest(){
        String line = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";

        // mock stopWords list
        CountResponse expectedResponse = mockFactory.createCountResponse(10, 8);

        // asserts
        Assertions.assertEquals(expectedResponse.getUniqueCount(), wordCounter.count(line, new ArrayList<>()).getUniqueCount());
        Assertions.assertEquals(expectedResponse.getTotalCount(), wordCounter.count(line, new ArrayList<>()).getTotalCount());

    }

    @Test
    public void countWithLineEmptyWordsTest(){
        String line = "";

        // mock stopWords list
        CountResponse expectedResponse = mockFactory.createCountResponse(0, 0);

        // asserts
        Assertions.assertEquals(expectedResponse.getUniqueCount(), wordCounter.count(line, new ArrayList<>()).getUniqueCount());
        Assertions.assertEquals(expectedResponse.getTotalCount(), wordCounter.count(line, new ArrayList<>()).getTotalCount());

    }

    @Test
    public void countWithLineNullTest(){
        String line = null;

        // mock stopWords list
        CountResponse expectedResponse = mockFactory.createCountResponse(0, 0);

        // asserts
        Assertions.assertEquals(expectedResponse.getUniqueCount(), wordCounter.count(line, new ArrayList<>()).getUniqueCount());
        Assertions.assertEquals(expectedResponse.getTotalCount(), wordCounter.count(line, new ArrayList<>()).getTotalCount());

    }
}
