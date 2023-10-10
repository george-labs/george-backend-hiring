import java.util.List;

public class EuropeanWordValidator implements WordValidator{
    @Override
    public boolean isValidWord(String word) {
        String REGEX = "^[a-zA-Z]+$";
        return word.matches(REGEX);
    }

    @Override
    public boolean isOnStopList(List<String> stopWords, String targetWord) {
        return stopWords.contains(targetWord);
    }
}
