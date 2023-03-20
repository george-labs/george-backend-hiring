import java.io.File;
import java.util.List;

public class WordCounter {

    private List<String> excluded;

    public WordCounter() {
        //default excluded words from resources
        File file = Utils.getFileFromResources("stopwords.txt");
        excluded = Utils.loadFileByLines(file);
    }

    public int countWords(String text) {
        if (text == null || text.isEmpty()) return 0;
        String[] words = text.split(" ");
        int count = 0;
        for (String s : words) {
            if (excluded.contains(s)) continue;
            if (s.matches("[A-Za-z]+")) count++;
        }
        return count;
    }
    
}
