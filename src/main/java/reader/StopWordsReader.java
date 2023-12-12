package reader;

import java.util.Set;

public class StopWordsReader extends FileReader {

    private static final String DEFAULT_STOPWORDS_FILE_PATH = "src/main/resources/stopwords.txt";

//    private String pathToFile = "src/main/resources/stopwords.txt";
//    private static final String PATH_TO_FILE = "src/main/resources/stopwords.txt";

    public StopWordsReader() {
        super(DEFAULT_STOPWORDS_FILE_PATH);
    }

    public StopWordsReader(String pathToFile) {
        super(pathToFile);
    }

    @Override
    public Set<String> read() {
            return Set.copyOf(super.read());
    }

//    @NotNull
//    public Path resolvePath() {
//        return Paths.get(Objects.isNull(pathToFile) ? PATH_TO_FILE : pathToFile);
//    }
}
