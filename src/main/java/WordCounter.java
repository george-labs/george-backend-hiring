import java.io.File;
import java.util.List;

public class WordCounter implements IWordCounter {

    private List<String> excluded;

    public WordCounter() {
        excluded = Utils.loadFileByLines(Utils.getFileFromResources("stopwords.txt"));
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

    public void loadExcludedWords(String fileName) {
        File file = Utils.getFile(fileName);
        if (file.exists()) {
            excluded = Utils.loadFileByLines(file);
        }
    }
}
