import java.io.InputStream;
import java.util.List;

public class FileReader {
    private final String PATH_TO_FILE = "stopwords.txt";
    private List<String> stopWords;

    public FileReader(){
        this.loadFile();
    }


    private void loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(PATH_TO_FILE);
        String data = readFromInputStream(inputStream);

    }
}
