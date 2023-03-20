import java.util.StringTokenizer;

public class WordCounter {

    public int countWords(String text) {
        return text.split("\\w+").length ;
    }
}
