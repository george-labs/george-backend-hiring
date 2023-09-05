package stopwords;

public class StopWordsReaderConfiguration {

    private final String stopWordsFileName;

    public StopWordsReaderConfiguration(String stopWordsFileName) {
        this.stopWordsFileName = stopWordsFileName;
    }

    public String getStopWordsFileName() {
        return stopWordsFileName;
    }

}
