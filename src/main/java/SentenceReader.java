import java.util.List;

public class SentenceReader {

    public String readSentence() {
        return WordUtils.readSentence();
    }

    public List<String> readWordsFromFile(String fileName)  {
        return WordUtils.readStopWordsFromFile(fileName);
    }
}
