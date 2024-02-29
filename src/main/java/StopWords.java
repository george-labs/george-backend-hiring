import java.util.Arrays;
import java.util.List;

public class StopWords {
    private FileReader fileReader;

    public StopWords(FileReader reader) {
        this.fileReader = reader;
    }

    public List<String> getStopWords() {
        String content = fileReader.readString("stopwords.txt");
        return Arrays.asList(content.split("\\n"));
    }
}
