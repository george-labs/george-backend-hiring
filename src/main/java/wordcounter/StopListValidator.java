package wordcounter;

public interface StopListValidator {

    boolean isOnStopList(String stopWords, String targetWord);
}
