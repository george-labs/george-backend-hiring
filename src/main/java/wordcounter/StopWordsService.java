package wordcounter;

import java.util.List;
import java.util.Set;

public class StopWordsService {

    private final Set<String> stopWords;

    public StopWordsService(String stopWordFileName, FileReader fileReader) {
        this.stopWords = readStopWords(stopWordFileName, fileReader);
    }

    public Set<String> getStopWords() {
        return stopWords;
    }

    private Set<String> readStopWords(String stopWordFileName, FileReader fileReader) {
        List<String> stopWords = fileReader.readFile(stopWordFileName);
        return Set.of(stopWords.toArray(new String[stopWords.size()]));
    }

}
