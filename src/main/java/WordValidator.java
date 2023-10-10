import java.util.List;

public interface WordValidator {
    boolean isValidWord(String word);
    boolean isOnStopList(List<String> stopWords, String targetWord);
}
