import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordCounter implements IWordCounter {

    private List<String> excluded;

    public WordCounter() {
        excluded = Utils.loadFileByLines(Utils.getFileFromResources("stopwords.txt"));
    }

    public CountResult countWords(String text) {
        if (text == null || text.isEmpty()) return new CountResult(0,0);
        String[] words = text.split("\\s+");
        int count = 0;
        Set<String> alreadyCounted = new HashSet<>();
        for (String s : words) {
            if (excluded.contains(s)) continue;
            if (s.matches("[A-Za-z]+")) {
                alreadyCounted.add(s);
                count++;
            }
        }
        return new CountResult(count, alreadyCounted.size());
    }

    public void loadExcludedWords(String fileName) {
        File file = Utils.getFile(fileName);
        if (file == null) return;
        excluded = Utils.loadFileByLines(file);
    }
}
