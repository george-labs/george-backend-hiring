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
}
