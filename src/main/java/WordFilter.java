import java.util.Collections;
import java.util.List;

public class WordFilter {

    public List<String > filterWords(String[] list, List<String> stopWords) {
        return WordUtils.filterWords(list, stopWords);
    }

    public List<String > filterWords(String[] list) {
        return filterWords(list, Collections.emptyList());
    }
}
