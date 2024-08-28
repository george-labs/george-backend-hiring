import java.io.IOException;
import java.util.List;

public class SentenceReader {

    public String readSentence() {
        return WordUtils.readSentence();
    }

    public List<String> readWordsFromFile() throws IOException {
        return WordUtils.readStopWordsFromFile();
    }
}
