import java.util.ArrayList;
import java.util.List;

public class MockFactory {

    public List<String> getStopWordsList(){
        List<String> stopWords = new ArrayList<>();
        stopWords.add("the");
        stopWords.add("a");
        stopWords.add("on");
        stopWords.add("off");
        return stopWords;
    }

    public CountResponse createCountResponse(int totalCount, int uniqueCount, float averageWordLength) {
        CountResponse countResponse = new CountResponse();
        countResponse.setTotalCount(totalCount);
        countResponse.setUniqueCount(uniqueCount);
        countResponse.setAverageWordLength(averageWordLength);
        return countResponse;
    }
}
