import java.util.List;

public class WordFilter {

    public List<String > filterWords(String[] list) {
        return WordUtils.filterWords(list);
    }
}
