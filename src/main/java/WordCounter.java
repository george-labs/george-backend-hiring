import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    private final String text;

    public WordCounter(String text) {
        this.text = text;
    }

    public long get(){
        // Pattern pattern = Pattern.compile("([a-zA-z]+)");  //^[a-zA-Z]+$
        String[] possibleWords = text.split("\\s");
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        long count = 0;
        for (String possible: possibleWords) {
            Matcher matcher = pattern.matcher(possible);
            if (matcher.find()){
                count++;
            }
        }
        return count;

    }
}
