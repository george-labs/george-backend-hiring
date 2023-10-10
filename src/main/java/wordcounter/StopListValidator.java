package wordcounter;

import java.util.List;

public interface StopListValidator {

    boolean isOnStopList(List<String> stopWords, String targetWord);
}
